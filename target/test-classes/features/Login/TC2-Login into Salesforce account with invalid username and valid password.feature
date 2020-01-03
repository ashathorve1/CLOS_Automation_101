Feature: Login into Salesforce account with invalid username and valid password
  Scenario: The system should not allow to login with invalid username and throw error by redirecting into same login page.
    Given I am in the Login page
    And I Enter my invalid username
    And I Enter my password
    And I Check Remember me
    When I Click on Login button
    Then I should not be able to log into my Salesforce account and redirected to same login page by throwing error