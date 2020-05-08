package steps;

import fragments.MainMenuFragment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.NewToursPage;
import pages.TableDemoPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SmokeNavigationSteps {

    HomePage homePage = new HomePage();
    NewToursPage newToursPage = new NewToursPage();
    TableDemoPage tableDemoPage = new TableDemoPage();
    MainMenuFragment mainMenuFragment = new MainMenuFragment();

    public MainMenuFragment getMainMenuFragment() {
        return mainMenuFragment;
    }

    @When("user navigate to homePage")
    public void userNavigateToHomePage() {
        homePage.navigate();
    }

    @Then("title of homePage is {string}")
    public void titleOfHomePageIs(String pageTitle) {
        assertEquals(pageTitle, homePage.getTitle());
    }

    @Then("login form is present")
    public void loginFormIsPresent() {
        assertTrue(homePage.isLoginFormPresent());
    }

    @Given("user is on homePage")
    public void userIsOnHomePage() {
        homePage.navigate();
    }

    @When("user click on newToursButton")
    public void userClickOnNewToursButton() {
        getMainMenuFragment().ClickOnNewToursButton();
    }

    @Then("title of newToursPage is {string}")
    public void titleOfNewToursPageIs(String pageTitle) {
        assertEquals(pageTitle, newToursPage.getTitle());
    }

    @Then("main fragment is present")
    public void mainFragmentIsPresent() {
        assertTrue(newToursPage.isMainMenuFragmentPresent());
    }

    @When("user click on tableDemoLink")
    public void userClickOnTableDemoLink() {
        getMainMenuFragment().clickOnTableDemo();
    }

    @Then("title of tablePage is {string}")
    public void titleOfTablePageIs(String pageTitle) {
        assertEquals(pageTitle, tableDemoPage.getTitle());
    }

    @Then("table is present")
    public void tableIsPresent() {
        assertTrue(tableDemoPage.isTableDemoPresent());
    }
}
