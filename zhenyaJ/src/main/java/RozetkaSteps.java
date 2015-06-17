
import junit.framework.TestCase;
import net.thucydides.jbehave.ThucydidesJUnitStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.impl.StaticLoggerBinder;


/**
 * Created by Sasha on 06.06.2015.
 */
public class RozetkaSteps  extends ThucydidesJUnitStories {
        public RozetkaSteps ()
        {
            super();
        }

        String btName=" ";
        String value=" ";
        String searchBar=" ";
        String material=" ";
        String data_range = " ";


        private String baseUrl = "http://rozetka.com.ua";
        webdriverActions  ws=new webdriverActions();


        @Given("main page rozetka.com.ua")
        public void givenMainPage() throws Exception{
            System.out.println("1");
            ws.get(baseUrl);
            ws.getWebDriver().manage().window().maximize();
            PageFactory.initElements(ws.getWebDriver(), RozetkaSteps.class);
            System.out.println("2");
        }

        @When("user has entered to the rozetka.com.ua")
        public void loginSystem() throws Exception {
            System.out.println("3");

        }

//        @When ("shopping cart is cleared")
//        public void cleaningTheCart(){
//            System.out.println("2");
//
//        }
//
//        @When("user goes to the nessessary products page for choosing")
//        public void goingToTheProductPage() throws InterruptedException  {
//            System.out.println("2");
//
//        }
//
//        @When("user goes to the nessessary huge products page for choosing")
//        public void goingToTheHugeProductPage() throws InterruptedException  {
//            System.out.println("2");
//
//        }
//
//        @When("total sum in shopping cart is less than 1500 grn")
//        public void totalSumLessThan1500() throws InterruptedException  {
//            System.out.println("2");
//
//        }
//
//        @When("total sum in shopping cart is more than 1500 grn")
//        public void totalSumMoreThan1500() throws InterruptedException {
//            System.out.println("2");
//
//        }
//
//        @When("total sum in shopping cart is more than 20000 grn")
//        public void totalSumMoreThan20000() throws InterruptedException {
//
//        }
//
//        @Then("shipping price is 35 grn")
//        public void gettingSumLess1500() {
//
//        }
//
//        @Then("shipping price is 0 grn")
//        public void gettingSumMoreThan1500() {
//
//        }

        @Then("gift is added to the shopping cart")
        public void gettingSumMoreThan20000() throws Exception{
            System.out.println("4");

        }
}
