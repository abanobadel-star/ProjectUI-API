package Steps;

import com.tests.TestBaseCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Searchpage;

import java.io.IOException;

public class searchOnGoogleStepDef extends TestBaseCucumber {

    public searchOnGoogleStepDef() throws IOException {
    }

    Searchpage searchpage ;
    @Given("user on google page")
    public void userOnGooglePage() {
        startdriver();
    }

    @When("user type {string} on search field")
    public void userTypeOnSearchField(String searchWord) {
        searchpage = new Searchpage(driver);
        searchpage.searchOnGoogle(searchWord);
    }

    @Then("check number of search result more than {int}")
    public void checkNumberOfSearchResultMoreThan(int numberOfResult) {
        searchpage.assertNumberOfResultSearch();
    }

    @When("user click on next button")
    public void userClickOnNextButton() {

    }

    @Then("verify number of search list for two pages are equals")
    public void verifyNumberOfSearchListForTwoPagesAreEquals() {
        searchpage.assertResultForTwoPage();
    }

    @And("check relative result part appear")
    public void checkRelativeResultPartAppear() {
        searchpage.assertRelativeSearchResultAppear();
    }
}
