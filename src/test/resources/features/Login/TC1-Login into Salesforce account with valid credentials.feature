Feature: Login into Salesforce account with valid credentials
  Scenario: The system should allow user to enter login credentials and allow to login into Salesforce account
    Given I am in the Login page
    And I Enter my username
    And I Enter my password
    And I Uncheck Remember me
    When I Click on Login button
    Then I should be able to logged into my Salesforce account and redirected to application home page