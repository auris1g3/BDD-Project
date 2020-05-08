package steps;

import fragments.MainMenuFragment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DragAndDropPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DragAndDropSteps {
    HomePage homePage = new HomePage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    MainMenuFragment mainMenuFragment = new MainMenuFragment();

    public MainMenuFragment getMainMenuFragment() {
        return mainMenuFragment;
    }

    @Given("user is on dragAndDrop page")
    public void userIsOnDragAndDropPage() {
        homePage.navigate();
        getMainMenuFragment().clickOnDragAndDropActions();
    }

    @Then("success message is not shown")
    public void successMessageIsNotShown() {
        assertTrue(dragAndDropPage.isNotMessageShown());
    }

    @When("user drop debit account {string}")
    public void userDropDebitAccount(String textButton) {
        assertEquals(textButton, dragAndDropPage.getBank().getText());
        dragAndDropPage.moveDebitAccount();
    }

    @Then("user drop debit amount {string}")
    public void userDropDebitAmount(String textButton) {
        assertEquals(textButton, dragAndDropPage.getSum().getText());
        dragAndDropPage.moveDebitAmount();
    }

    @Then("user drop credit account {string}")
    public void userDropCreditAccount(String textButton) {
        assertEquals(textButton, dragAndDropPage.getSale().getText());
        dragAndDropPage.moveCreditAccount();
    }

    @Then("user drop credit amount {string}")
    public void userDropCreditAmount(String textButton) {
        assertEquals(textButton, dragAndDropPage.getSum().getText());
        dragAndDropPage.moveCreditAmount();
    }

    @Then("success message is shown")
    public void isSuccessMessageShown() {
        assertTrue(dragAndDropPage.isMessageShown());
    }
}
