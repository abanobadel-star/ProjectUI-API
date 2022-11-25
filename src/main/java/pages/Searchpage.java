package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Searchpage extends PageBase {

	public Searchpage(WebDriver driver) {
		super(driver);
	}

	/**
	 * search text field element.
	 */
	@FindBy(css = "input[name='q']")
	WebElement searchTextField;

	/**
	 * search result list.
	 */
	@FindBy(css = "div.GLI8Bc.UK95Uc")
	public List<WebElement> searchResult;

	/**
	 * next button.
	 */
	@FindBy(css = "tbody span:nth-child(2)")
	WebElement nextButton;

	/**
	 * relative search result list.
	 */
	@FindBy(css = "a.k8XOCe.R0xfCb.VCOFK.s8bAkb")
	public List<WebElement> relativeSearchResult;

	/**
	 * method to search on google
	 * @param wordToSearchOnIt word that want to search on it
	 */
	public void searchOnGoogle(String wordToSearchOnIt) {
		searchTextField.click();
		searchTextField.clear();
		searchTextField.sendKeys(wordToSearchOnIt);
		searchTextField.clear();
		searchTextField.sendKeys(wordToSearchOnIt);
		searchTextField.sendKeys(Keys.ENTER);
	}

	/**
	 * method to check number of list result.
	 * @return true when list of result more than or equal 7 , return false when list of result less than 7
	 */
	public Boolean assertNumberOfResultSearch () {
		int numberOfExpectedSearchResult = searchResult.size();
		System.out.println("Number of search result : " + numberOfExpectedSearchResult);
		if( numberOfExpectedSearchResult >= 7) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * method to click on next button.
	 */
	public void clickOnNextButton () {
		nextButton.click();
	}

	/**
	 * method to compare list of result from two page.
	 */
	public void assertResultForTwoPage() {
		clickOnNextButton();
		int ActualNumberOFSearchResultPageTwo = searchResult.size();
		clickOnNextButton();
		int ActualNumberOFSearchResultPageThree = searchResult.size();
		if(ActualNumberOFSearchResultPageTwo == ActualNumberOFSearchResultPageThree) {
			Assert.assertEquals(ActualNumberOFSearchResultPageThree,ActualNumberOFSearchResultPageTwo);

		} else {
			Assert.assertNotSame(ActualNumberOFSearchResultPageThree, ActualNumberOFSearchResultPageTwo);
		}
	}

	/**
	 * method to check relative search appear.
	 */
	public void assertRelativeSearchResultAppear () {
		for (int i =0 ; i < relativeSearchResult.size(); i++)
		Assert.assertTrue(relativeSearchResult.get(i).isDisplayed());
	}
}
