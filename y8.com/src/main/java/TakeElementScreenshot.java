import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Created by Sasha on 03.06.2015.
 */
public class TakeElementScreenshot {


    private final String screenshotFolder = "screen\\";
    protected WebDriver driver;

    public TakeElementScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void shoot(WebElement element) throws IOException {

        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        org.openqa.selenium.Point p = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        Rectangle rect = new Rectangle(width, height);
        BufferedImage img = null;
        img = ImageIO.read(screen);
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(),rect.width, rect.height);
        ImageIO.write(dest, "png", screen);
        FileUtils.copyFile(screen, new File(screenshotFolder
                + System.currentTimeMillis() + ".png"));
    }


}