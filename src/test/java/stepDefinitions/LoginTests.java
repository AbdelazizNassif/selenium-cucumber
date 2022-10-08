package stepDefinitions;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.NavigationBarPage;

import static readers.ConfigReaders.getPropertyByKey;

public class LoginTests {
    HomePage homePage;
    NavigationBarPage navigationBarPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Given("User is not logged in home page")
    public void userIsNotLoggedInHomePage() {
        homePage = new HomePage(DriverFactory.getDriver()).navigate();
        navigationBarPage = new NavigationBarPage(DriverFactory.getDriver());
    }

    @When("User visit login page")
    public void userVisitLoginPage() {
        loginPage = navigationBarPage.clickSignInLink();
    }

    @Then("The login page title should be {string}")
    public void thePageTitleShouldBe(String expectedPageTitle) {
        Assert.assertEquals("page title should be " + expectedPageTitle,
                loginPage.getCurrentPageTitle(),
                expectedPageTitle);
    }

    @Then("The user should see forget password link")
    public void theUserShouldSeeForgetPasswordLink() {
        Assert.assertTrue("forget password link should be displayed",
                loginPage.isForgotPasswordDisplayed());
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        myAccountPage = loginPage.loginToApp(getPropertyByKey("EMAIL"),
                getPropertyByKey("PASSWORD"));
    }


    @Then("The user is should see {string} label")
    public void theUserIsShouldSeeLabel(String myAccountLabel) {
        Assert.assertEquals("page title should be " + myAccountLabel,
                myAccountPage.getMyAccountLabelText(),
                myAccountLabel);
    }
    @Then("The account title should be {string}")
    public void theAccountTitleShouldBe(String expectedPageTitle) {
        Assert.assertEquals("page title should be " + expectedPageTitle,
                myAccountPage.getCurrentPageTitle(),
                expectedPageTitle);
    }


}
