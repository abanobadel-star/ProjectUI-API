Feature: Search On Google

  @Regression
  Scenario Outline: verify user can search for any keywords on google
    Given user on google page
    When user type "<keyword>" on search field
    Then check number of search result more than 7
    When user click on next button
    Then verify number of search list for two pages are equals
    And check relative result part appear

    Examples:
    |keyword|
    |iphone 14 pro max|

