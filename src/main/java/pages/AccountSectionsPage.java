package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiActions.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class AccountSectionsPage {

    private WebDriver driver;

    // constructor
    public AccountSectionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By sectionsInsideAccount = By.cssSelector(".myaccount-link-list>li") ;

    // operations
    public List<String> getSectionsInsideAccount ()
    {
        List<String> sectionsText = new ArrayList<>();
        List<WebElement> accountSections = ElementUtil.locateListOfElements(driver,sectionsInsideAccount ) ;
        for (WebElement section : accountSections)
        {
            sectionsText.add(section.getText());
        }
        return sectionsText ;
    }

}
