package uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {

//    WebDriver driver;

//
//    public BasePage(WebDriver driver) {
//        this.driver = driver;
//
//    }

    public static WebElement locateElement (WebDriver driver, By elementLocator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElement(elementLocator);
    }
    public static List locateListOfElements (WebDriver driver, By elementsLocator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementsLocator));
        return driver.findElements(elementsLocator);
    }
    public static String getPageTitle (WebDriver driver)
    {
        return driver.getTitle();
    }
    public static void clickElement (WebDriver driver, By elementLocator)
    {
        locateElement(driver, elementLocator).click();
    }
    public static void typeOnElement (WebDriver driver, By elementLocator, String text)
    {
        locateElement(driver, elementLocator).sendKeys(text);
    }
    public static boolean isElementDisplayed (WebDriver driver, By elementLocator)
    {
        return locateElement(driver, elementLocator).isDisplayed();
    }
    public static String getTextOfElement(WebDriver driver, By elementLocator)
    {
        return locateElement(driver, elementLocator).getText();
    }

//
//    public String getAttributeOfElement (By elementLocator, String attributeKey)
//    {
//        return locateElement(elementLocator).getAttribute(attributeKey);
//    }
}
