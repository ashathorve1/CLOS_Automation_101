Feature: Login into Salesforce account by keeping user name and password blank
  Scenario: The system should not allow to login with blank details and throw error by redirecting into same login page

    Given I am in the Login page
    And I keep blank username
    And I keep blank password
    And I Uncheck Remember me
    When I Click on Login button
    Then I should not be able to log into my Salesforce account and redirected to same login page by throwing error