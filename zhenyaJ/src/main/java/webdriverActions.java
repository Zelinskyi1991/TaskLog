import net.thucydides.jbehave.ThucydidesJUnitStories;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * Created by Sasha on 06.06.2015.
 */
public class webdriverActions   {
    protected WebDriver _driver;

    @BeforeScenario
    public void setUp() throws Exception {
        _driver = new FirefoxDriver();
    }

    public void get(String baseUrl) throws Exception{
        _driver.get(baseUrl);
    }

    public WebDriver getWebDriver() throws Exception{
        return _driver;
    }

    @AfterScenario
    public void tearDown() throws Exception {
        _driver.close();
    }
}
