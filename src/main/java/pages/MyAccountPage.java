package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiActions.ElementUtil;

public class MyAccountPage {

    private WebDriver driver;

    // constructor
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By myAccountLabel = By.cssSelector(".page-heading");


    // operations
    public String getCurrentPageTitle ()
    {
        return ElementUtil.getPageTitle(driver);
    }
    public String getMyAccountLabelText ()
    {
        return ElementUtil.getTextOfElement(driver, myAccountLabel);
    }
}
