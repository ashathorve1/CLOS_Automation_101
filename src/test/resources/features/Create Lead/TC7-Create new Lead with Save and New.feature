Feature: Create new Lead with Save and New
  Scenario Outline: The system shall create a new lead after all fields completed with valid data for lead creation and open new lead creation page
    Given I login to Salesforce URL
    When I click on Leads tag
    And I click New button on right hand side of the page
    And I provide Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, First Name, Last Name, Date of Incorporation, Street, City, Country, Loan Application Name, Amount, Loan Purpose and Expected Date
      |Company | Website | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | First Name  |Last Name | Date of Incorporation |Street | City | Country | Loan Application Name | Amount | Loan Purpose |Expected Date |
      | <Company> | <Website> | <CIN> |<Group> | <Email> | <Annual Revenue> | <Ownership> | <Lead Status> | <First Name>| <Last Name> | <Date of Incorporation> | <Street> | <City> | <Country> | <Loan Application Name>| <Amount> |<Loan Purpose>|<Expected Date> |
    And I click on Save & New button
    And again I provide Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, First Name, Last Name, Date of Incorporation, Street, City, Country, Loan Application Name, Amount, Loan Purpose and Expected Date
  |Company | Website | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | First Name  |Last Name | Date of Incorporation |Street | City | Country | Loan Application Name | Amount | Loan Purpose |Expected Date |
  | <Company> | <Website> | <CIN> |<Group> | <Email> | <Annual Revenue> | <Ownership> | <Lead Status> | <First Name>| <Last Name> | <Date of Incorporation> | <Street> | <City> | <Country> | <Loan Application Name>| <Amount> |<Loan Purpose>|<Expected Date> |
    And I click on Save button
    And I again click Leads tab
    And I type the leads "Liam" in the Search box and press Enter to view the particular contact detail
    And I click on the searched lead name
    Then I verified Lead is successfully created with Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, First Name, Last Name, Date of Incorporation, Street, City, Country, Loan Application Name, Amount, Loan Purpose and Expected Date
    Examples:
      |Company | Website  | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | First Name |Last Name | Date of Incorporation | Street | City | Country | Loan Application Name | Amount | Loan Purpose | Expected Date |
      | ASA Company1  | www.aelon.com | 742252874666  | Group AAC  | supportserv@gmail.com | 600000000 | Private | Working - Contacted | Payne |Liam | 15/1/2020| High Street| Pune | India | Personal Loan | 2000000 | Refinance Loan | 15/1/2020 |