package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

import java.io.FileReader;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static readers.ConfigReaders.getPropertyByKey;

public class AccountTests {
    HomePage homePage;
    NavigationBarPage navigationBarPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    AccountSectionsPage accountSectionsPage;
    List<String> sectionsText;

    @Given("user has already logged in to application")
    public void userHasAlreadyLoggedInToApplication() {
        homePage = new HomePage(DriverFactory.getDriver()).navigate();
        navigationBarPage = new NavigationBarPage(DriverFactory.getDriver());
        loginPage = navigationBarPage.clickSignInLink();
        myAccountPage = loginPage.loginToApp(getPropertyByKey("EMAIL"),
                getPropertyByKey("PASSWORD"));
    }

    @Given("user is on Accounts page")
    public void userIsOnAccountsPage() {
        accountSectionsPage = navigationBarPage.clickOwnAccountLink();
    }

    @When("user checks the available sections")
    public void userChecksTheAvailableSections() {
        sectionsText = accountSectionsPage.getSectionsInsideAccount();
    }

    @Then("user should see {int} sections")
    public void userShouldSeeSections(int numberOfSections, DataTable sections) {
        Assert.assertEquals(sectionsText.size(), numberOfSections);
        List<String> sectionsTableAsList = sections.asList();
        for (int iterator=0; iterator<sectionsText.size(); iterator++)
        {
            Assert.assertEquals(sectionsText.get(iterator), sectionsTableAsList.get(iterator+1));
        }

    }
}
