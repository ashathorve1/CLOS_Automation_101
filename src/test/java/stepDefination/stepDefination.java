package stepDefination;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import navigation.NavigateTo;
import org.openqa.selenium.By;
import pageObject.ForgotPassword;
import pageObject.HomePage;
import pageObject.LeadsPage;
import pageObject.LoginPage;

import java.util.List;
import java.util.Map;

public class stepDefination extends NavigateTo {
    @Steps
    String leadsTab="Leads".trim();

    @Given("^I am in the Login page$")
    public void i_am_in_the_Login_page(){
        driver=initializeDriver();
    }
    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    @And("^I Enter my username$")
    public void i_enter_my_username() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getUsername().sendKeys(getConfigurationDetails("clos.valid.username"));
    }

    @And("^I Enter my password$")
    public void i_enter_my_password() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getPassword().sendKeys(getConfigurationDetails("clos.valid.password"));
    }


    @And("^I Uncheck Remember me$")
    public void i_uncheck_remember_me() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        if (loginPage.getrememberMe().isSelected()) {
            loginPage.getrememberMe().click();
        }
    }

    @When("^I Click on Login button$")
    public void i_click_on_login_button() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        waitfortheelement();
        loginPage.getLoginBtn().click();
    }

    @Then("^I should be able to logged into my Salesforce account and redirected to application home page$")
    public void i_should_be_able_to_logged_into_my_salesforce_account_and_redirected_to_application_home_page() throws Throwable {
        waitfortheelement();
        HomePage homePage=new HomePage(driver);
        if(homePage.getAppIcon().isDisplayed()){
            System.out.println("TC1 Pass");
        }
        else {
            System.out.println("TC1 Fail");
        }
        driver.close();
    }

    @And("^I Enter my invalid username$")
    public void i_enter_my_invalid_username() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getUsername().sendKeys(getConfigurationDetails("clos.invalid.username"));
    }

    @And("^I Check Remember me$")
    public void i_check_remember_me() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        if(loginPage.getrememberMe().isSelected()==false){
            loginPage.getrememberMe().click();
        }
    }

    @Then("^I should not be able to log into my Salesforce account and redirected to same login page by throwing error$")
public void i_should_not_be_able_to_log_into_my_Salesforce_account_and_redirected_to_same_login_page_by_throwing_error()
{
    waitfortheelement();
    waitfortheelement();
    LoginPage loginPage=new LoginPage(driver);
        if (loginPage.getError().getText().equals(loginPage.getErrorText())) {
            System.out.println("TC Pass");
        }
        else {
            System.out.println("TC Fail");
        }
    driver.close();

    }

    @And("^I Enter my invalid password$")
    public void i_enter_my_invalid_password() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getPassword().sendKeys(getConfigurationDetails("clos.invalid.passsword"));
    }

    @And("^I keep blank username$")
    public void i_keep_blank_username() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getUsername().sendKeys("");
    }

    @And("^I keep blank password$")
    public void i_keep_blank_password() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getPassword().sendKeys("");

    }

    @When("^I click on Forgot Password$")
    public void i_click_on_forgot_password() throws Throwable {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getForgotPwd().click();
        waitfortheelement();
    }

    @Then("^I should get directed to Forgot your password page to reset$")
    public void i_should_get_directed_to_forgot_your_password_page_to_reset() throws Throwable {
        ForgotPassword forgot=new ForgotPassword(driver);
        if (forgot.pageTitle().equals(driver.getTitle())){
            System.out.println("TC Pass");
        }
        else {
            System.out.println("TC Fail");
        }
        driver.close();
    }

    @Given("^I login to Salesforce URL$")
    public void i_login_to_salesforce_url() throws Throwable {
        driver1=logintoSalesforce();
    }

    @When("^I click on (.*) tag")
    public void i_click_on_leads_tag(String fieldtab) throws Throwable {
        waitfortheelement();
        HomePage homePage=new HomePage(driver1);
        homePage.clickLeads(driver1,leadsTab);
        waitfortheelement();
         }


    @And("^I click (.*) button on right hand side of the page$")
    public void i_click_new_button_on_right_hand_side_of_the_page(String NewButton) throws Throwable {
        waitfortheelement();
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.newPage(driver1,NewButton.trim());
        waitfortheelement();
    }

    @And("^I provide (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iProvide(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet,
                         String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate, DataTable dataTable)
    {
        waitfortheelement();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group= data.get(0).get("Group");
        String Email= data.get(0).get("Email");
        String Annual= data.get(0).get("Annual Revenue");
        String Ownership= data.get(0).get("Ownership");
        String Lead_status= data.get(0).get("Lead Status");
        String Last_Name= data.get(0).get("Last Name");
        String First_Name= data.get(0).get("First Name");
        String Incop_Date= data.get(0).get("Date of Incorporation");
        String Street= data.get(0).get("Street");
        String City= data.get(0).get("City");
        String Country= data.get(0).get("Country");
        String Loan_Name= data.get(0).get("Loan Application Name");
        String Amount= data.get(0).get("Amount");
        String Loan_Purpose= data.get(0).get("Loan Purpose");
        String Exp_date= data.get(0).get("Expected Date");
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.NewLeadsValues(driver1,fieldCompany,fieldWebsite,fieldCIN,fieldGroup,fieldEmail,fieldAnnual,fieldOwnership,fieldLeadstat,fieldFirstName,fieldLastName,
                fieldIncop,fieldStreet,fieldCity,fieldCountry,fieldLoanName, fieldAmount, fieldLoanpurpose,fieldExpdate,
                Company, Website, CIN, Group, Email, Annual,Ownership,Lead_status,First_Name, Last_Name,Incop_Date,Street,City, Country,Loan_Name,Amount, Loan_Purpose ,Exp_date);
        waitfortheelement();
    }


    @And("^I click on (.*) button")
    public void i_click_on_Save_button(String saveButton) {
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.clickOnSave(driver1, saveButton);
        waitfortheelement();
    }
    @And("^I again click (.*) tab$")
    public void iClickOnLeads(String fieldtab) {
        waitfortheelement();
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.againLeads(driver1,leadsTab);
        waitfortheelement();
    }

    @And("^I type the leads \"(.*)\" in the Search box and press Enter to view the particular contact detail$")
    public void search_enter(String arg1) {
        waitfortheelement();
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.leadsNameInSearch(driver1, arg1);
        waitfortheelement();
    }

    @And("I click on the searched lead name$")
    public void searched_contact_name() {
        waitfortheelement();
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.searchLeadName(driver1);
    }

    @Then("^I verified Lead is successfully created with (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void iVerifiedSuccessfully (String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet,
                                       String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate, DataTable dataTable) {


        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group= data.get(0).get("Group");
        String Email= data.get(0).get("Email");
        String Annual= data.get(0).get("Annual Revenue");
        String Ownership= data.get(0).get("Ownership");
        String Lead_status= data.get(0).get("Lead Status");
        String Last_Name= data.get(0).get("Last Name");
        String First_Name= data.get(0).get("First Name");
        String Incop_Date= data.get(0).get("Date of Incorporation");
        String Street= data.get(0).get("Street");
        String City= data.get(0).get("City");
        String Country= data.get(0).get("Country");
        String Loan_Name= data.get(0).get("Loan Application Name");
        String Amount= data.get(0).get("Amount");
        String Loan_Purpose= data.get(0).get("Loan Purpose");
        String Exp_date= data.get(0).get("Expected Date");
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.displayedValues(driver1,fieldCompany,fieldWebsite,fieldCIN,fieldGroup,fieldEmail,fieldAnnual,fieldOwnership,fieldLeadstat,fieldFirstName,fieldLastName,
                fieldIncop,fieldStreet,fieldCity,fieldCountry,fieldLoanName, fieldAmount, fieldLoanpurpose,fieldExpdate,
                Company, Website, CIN, Group, Email, Annual,Ownership,Lead_status,First_Name, Last_Name,Incop_Date,Street,City, Country,Loan_Name,Amount, Loan_Purpose ,Exp_date);
    }

    @And("^I provide values in (.*),(.*),(.*),(.*),(.*),(.*) and (.*)$")
    public void i_provide_values(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, String filedChargebackResponseBy, String filedChargebackActualResponseDate, String filedChargebackSSTResponse, String filedChargebackBankFinalNotificationDate, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String chargebackBankAction = data.get(0).get("Chargeback Bank Action");
        String chargebackReceivedOn = data.get(0).get("Chargeback Received On");
        String chargebackReferenceNumber = data.get(0).get("Chargeback Reference Number");
        String chargebackResponseBy = data.get(0).get("Chargeback Response By");
        String chargebackActualResponseDate = data.get(0).get("Chargeback Actual Response Date");
        String chargebackSSTResponse = data.get(0).get("Chargeback SST Response");
        String chargebackBankFinalNotificationDate = data.get(0).get("Chargeback Bank Final Notification Date");
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.chargebackValues(driver1, fieldChargebackBankAction, fieldChargebackReceivedOn, filedChargebackReferenceNumber, filedChargebackResponseBy, filedChargebackActualResponseDate, filedChargebackSSTResponse, filedChargebackBankFinalNotificationDate, chargebackBankAction, chargebackReceivedOn, chargebackReferenceNumber, chargebackResponseBy, chargebackActualResponseDate, chargebackSSTResponse, chargebackBankFinalNotificationDate);
    }


    @And("^demo$")
    public void demo() throws Throwable {
        driver1.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='Company']//..//..//input")).sendKeys("Demo");
    }

    @And("^again I provide (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void again_iProvide(String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet,
                         String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate, DataTable dataTable)
    {
        waitfortheelement();
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String Company = data.get(0).get("Company");
        String Website = data.get(0).get("Website");
        String CIN = data.get(0).get("CIN");
        String Group= data.get(0).get("Group");
        String Email= data.get(0).get("Email");
        String Annual= data.get(0).get("Annual Revenue");
        String Ownership= data.get(0).get("Ownership");
        String Lead_status= data.get(0).get("Lead Status");
        String Last_Name= data.get(0).get("Last Name");
        String First_Name= data.get(0).get("First Name");
        String Incop_Date= data.get(0).get("Date of Incorporation");
        String Street= data.get(0).get("Street");
        String City= data.get(0).get("City");
        String Country= data.get(0).get("Country");
        String Loan_Name= data.get(0).get("Loan Application Name");
        String Amount= data.get(0).get("Amount");
        String Loan_Purpose= data.get(0).get("Loan Purpose");
        String Exp_date= data.get(0).get("Expected Date");
        LeadsPage leadsPage=new LeadsPage(driver1);
        leadsPage.NewLeadsValues(driver1,fieldCompany,fieldWebsite,fieldCIN,fieldGroup,fieldEmail,fieldAnnual,fieldOwnership,fieldLeadstat,fieldFirstName,fieldLastName,
                fieldIncop,fieldStreet,fieldCity,fieldCountry,fieldLoanName, fieldAmount, fieldLoanpurpose,fieldExpdate,
                Company.concat("1101"), Website.concat("1"), CIN.concat("1"), Group, Email.concat("1"), Annual,Ownership,Lead_status,First_Name.concat("1"), Last_Name.concat("1"),Incop_Date,Street.concat("101"),City.concat("1"), Country,Loan_Name,Amount, Loan_Purpose ,Exp_date);
        waitfortheelement();
    }
    @Then("^Ok$")
    public void ok() throws Throwable {
    }
}
