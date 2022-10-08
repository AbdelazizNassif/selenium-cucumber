package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiActions.ElementUtil;

public class NavigationBarPage {

    private WebDriver driver;

    // constructor
    public NavigationBarPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    static By signInLink = By.cssSelector(".login");
    static By userNameLink = By.cssSelector(".account>span");


    // operations
    public LoginPage clickSignInLink ()
    {
        ElementUtil.clickElement(driver, signInLink);
        return new LoginPage(driver);
    }
    public AccountSectionsPage clickOwnAccountLink ()
    {
        ElementUtil.clickElement(driver, userNameLink);
        return new AccountSectionsPage(driver) ;
    }

}
