package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiActions.ElementUtil;

public class LoginPage {

    private WebDriver driver;

    // constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    private static By emailInputField = By.id("email");
    private static By passwordInputField = By.id("passwd");
    private static By signInBtn = By.id("SubmitLogin");
    private static By forgotPasswordLink = By.cssSelector(".lost_password > a");


    // operations
    public String getCurrentPageTitle ()
    {
        return ElementUtil.getPageTitle(driver);
    }
    public boolean isForgotPasswordDisplayed ()
    {
        return ElementUtil.isElementDisplayed(driver, forgotPasswordLink);
    }
    public MyAccountPage loginToApp  (String email, String password)
    {
        ElementUtil.typeOnElement(driver, emailInputField, email);
        ElementUtil.typeOnElement(driver, passwordInputField, password);
        ElementUtil.clickElement(driver, signInBtn);
        return new MyAccountPage (driver) ;
    }
//    public AccountPage loginToApp()
//    {
//
//    }
}
