package pages;

import org.openqa.selenium.WebDriver;
import uiActions.ElementUtil;

public class HomePage {

    private WebDriver driver;
    private final static String APP_URL = "http://automationpractice.com/";

    // constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // locators


    // operations
    public HomePage navigate ()
    {
        driver.get(APP_URL);
        return this ;
    }

    public String getCurrentPageTitle ()
    {
        return ElementUtil.getPageTitle(driver);
    }
}
