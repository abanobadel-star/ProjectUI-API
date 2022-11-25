package com.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import pages.Searchpage;


public class SearchTest extends TestBase {

    public SearchTest() throws IOException {
        super();
    }

    Searchpage searchpage;
    public String wordToSearchOnIt = "iphone 14 pro max";

    @Test(description = "verify User Can Search On Google", priority = 0)
    public void verifyUserCanSearchOnGoogle() {
        searchpage = new Searchpage(driver);
        searchpage.searchOnGoogle(wordToSearchOnIt);
    }


    @Test(description = "Verify that number of search Result Equal To Actual number", priority = 1)
    public void VerifyThatNumberOfSearchResultEqualToActualNumber() {
        searchpage.assertNumberOfResultSearch();
    }

    @Test(description = "verify search result for page two equal to page Three", priority = 2)
    public void verifySearchResultForPagTwoEqualToPageThree() {
        searchpage.assertResultForTwoPage();
    }

    @Test(description = "verify that relative search appear", priority = 3)
    public void verifyThatRelativeSearchAppear() {
        searchpage.assertRelativeSearchResultAppear();
    }

}
