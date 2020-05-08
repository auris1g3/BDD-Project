package steps;

import fragments.MainMenuFragment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UploadFilePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UploadFileSteps {
    HomePage homePage = new HomePage();
    UploadFilePage uploadFilePage = new UploadFilePage();
    MainMenuFragment mainMenuFragment = new MainMenuFragment();

    public MainMenuFragment getMainMenuFragment() {
        return mainMenuFragment;
    }

    @Given("user is on uploadFilePage")
    public void userIsOnUploadFilePage() {
        homePage.navigate();
        getMainMenuFragment().clickOnUploadFile();
    }

    @Then("title of page is {string}")
    public void titleOfPageIs(String pageTitle) {
        assertEquals(pageTitle, uploadFilePage.getTitle());
    }

    @Then("user click Choose File button")
    public void userClickChooseFileButton() {
        uploadFilePage.clickOnChooseFileButton();
    }

    @Then("add file path")
    public void addFilePath() throws Exception {
        uploadFilePage.addFile();
    }

    @When("click Submit File button")
    public void clickSubmitFileButton() {
        uploadFilePage.clickOnSubmitButton();
    }

    @Then("message is shown")
    public void messageIsShown() {
        assertTrue(uploadFilePage.isMessageShown());
    }
}
