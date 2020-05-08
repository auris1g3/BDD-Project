package steps;

import com.codeborne.selenide.Selenide;
import fragments.AgileLoginFragment;
import fragments.MainMenuFragment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AgilePage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgileProjectSteps {
    HomePage homePage = new HomePage();
    AgilePage agilePage = new AgilePage();
    AgileLoginFragment agileLoginFragment = new AgileLoginFragment();
    MainMenuFragment mainMenuFragment = new MainMenuFragment();

    public AgileLoginFragment getAgileLoginFragment() {
        return agileLoginFragment;
    }

    public MainMenuFragment getMainMenuFragment() {
        return mainMenuFragment;
    }

    @Given("user is on home page")
    public void userIsOnHomePage() {
        homePage.navigate();
    }

    @When("user navigates to agile page")
    public void userNavigatesToAgilePage() {
        getMainMenuFragment().clickOnAgileProjectButton();
    }

    @Then("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String userName, String password) {
        getAgileLoginFragment().EnterLoginAndPassword(userName, password);
    }

    @And("click login button")
    public void clickLoginButton() {
        getAgileLoginFragment().clickOnLoginButton();
    }

    @Then("welcome message is present")
    public void welcomeMessageIsCorrect() {
        assertTrue(agilePage.isWelcomeMessagePresent());
    }

    @Then("unvalid credentials message is shown")
    public void unvalidCredentialsMessageIsShown() {
        assertEquals("User or Password is not valid", Selenide.switchTo().alert().getText());
        Selenide.switchTo().alert().accept();
    }
}
