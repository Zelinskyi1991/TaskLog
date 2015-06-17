import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class y8com
{
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver =new FirefoxDriver();
        driver.get("http://www.y8.com/");
        //driver.get("http://www.y8.com/tags/idnet");
        ///driver.get("C:\\Users\\Sasha\\Desktop\\1.html");
        BufferedWriter br=new BufferedWriter(new FileWriter("xas.txt"));
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement dynamicElement;
        WebElement elementImg;

        for (int j = 1; ; j++)
        {
            try
            {
                //ZAPUSKAEM listener novih kartinok
                //xpath : dla pervoi kartinki po nomeru diva
                dynamicElement = (new WebDriverWait(driver, 5))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[" + j + "]/a[1]/div")));
            }
            catch (TimeoutException e)
            {
                // tut viipolnyaetsya kod posle zagruzki vseh kartinok
                System.out.println("\n\n Test complited \n\n");

                driver.close();

                break;
            }



            // debug
            //System.out.println(dynamicElement.getAttribute("class") );

            // poluchaem element kartinku dla dannoy igri
            elementImg = dynamicElement.findElement(By.tagName("img"));
            int w=Integer.parseInt(elementImg.getAttribute("width"));
            int h=Integer.parseInt(elementImg.getAttribute("height"));

            // vivod loga v konsole
            System.out.println( "#[" + j + "]: game name: '" + elementImg.getAttribute("alt") +"' size of image: " + w + "x" + h );


            if(w!=180 || h!=135)
            {
                //vedem log v file za.txt
                System.out.println("\n\n WARNING: missmatch size for: '" + elementImg.getAttribute("alt") + "' \n\n ");
                br.write( "#[" + j + "]: game name: '" + elementImg.getAttribute("alt") +"' size of image: " + w + "x" + h );
                br.newLine();
                TakeElementScreenshot screenshot = new TakeElementScreenshot(driver);
                screenshot.shoot(elementImg);


            }

            //pri zagruzke 8 kartinok delaem scrolldown
            if (j % 8 == 0) {
                int newvisota = driver.findElement(By.tagName("body")).getSize().getHeight();
                ((JavascriptExecutor) driver).executeScript("scrollTo(0," + newvisota + " )");
            }


        }

        br.close();


    }


}