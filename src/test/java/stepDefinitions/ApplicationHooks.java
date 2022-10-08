package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import readers.ConfigReaders;

import java.util.Properties;

import static readers.ConfigReaders.getPropertyByKey;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReaders configReader;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReaders();
        System.out.println(System.getProperty("BROWSER"));
        System.out.println(System.getProperty("cucumber.publish.enabled"));
        System.out.println(System.getProperty("BROWSER"));
    }
    @Before(order = 1)
    public void launchBrowser() {
        String browserName = getPropertyByKey("BROWSER");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName);

    }
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }
}
