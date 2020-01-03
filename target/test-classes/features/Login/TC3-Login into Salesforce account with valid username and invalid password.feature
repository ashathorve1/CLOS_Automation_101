Feature: Login into Salesforce account with valid username and invalid password
  Scenario: The system should not allow to login with invalid password and throw error by redirecting into same login page
    Given I am in the Login page
    And I Enter my username
    And I Enter my invalid password
    And I Uncheck Remember me
    When I Click on Login button
    Then I should not be able to log into my Salesforce account and redirected to same login page by throwing error
