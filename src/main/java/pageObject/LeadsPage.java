package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LeadsPage {
    public WebDriver driver;


    public LeadsPage(WebDriver driver){
        this.driver=driver;
    }

    public void newPage(WebDriver driver, String newButton) {
        driver.findElement(By.xpath("//div[@class='test-listViewManager slds-grid slds-grid--vertical forceListViewManager']//div[@class='slds-truncate'][text()='"+newButton+"']")).click();

    }

    public void NewLeadsValues(WebDriver driver, String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet, String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate,
                               String company, String website, String cin, String group, String email, String annual, String ownership, String lead_status, String first_name, String last_name, String incop_date, String street, String city, String country, String loan_name, String amount, String loan_purpose, String exp_date)
    {
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCompany+"']//..//..//input")).sendKeys(company);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldWebsite+"']//..//..//input")).sendKeys(website);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCIN+"']//..//..//input")).sendKeys(cin);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldEmail+"']//..//..//input")).sendKeys(email);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldAnnual+"']//..//..//input")).sendKeys(annual);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//div[@class='slds-form-element slds-hint-parent']//span[contains(text(),'"+fieldOwnership+"')]//..//..//a[@class='select']")).click();
        driver.findElement(By.xpath("//div[@class='select-options']//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='"+ownership+"']")).click();
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldGroup+"']//..//..//input")).sendKeys(group);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//div[@role='listbox']//div[@title='"+group+"']")).click();
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//div[@class='slds-form-element slds-hint-parent']//span[contains(text(),'"+fieldLeadstat+"')]//..//..//a[@class='select']")).click();
        driver.findElement(By.xpath("//div[@class='select-options']//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='"+lead_status+"']")).click();
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldIncop+"']//..//..//input")).sendKeys(incop_date);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldStreet+"']//..//..//textarea")).sendKeys(street);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,200)");
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCity+"']//..//..//input")).sendKeys(city);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCountry+"']//..//..//input")).sendKeys(country);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldFirstName+"']//..//..//input")).sendKeys(first_name);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldLastName+"']//..//..//input")).sendKeys(last_name);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldLoanName+"']//..//..//input")).sendKeys(loan_name);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldAmount+"']//..//..//input")).sendKeys(amount);
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//div[@class='slds-form-element slds-hint-parent']//span[contains(text(),'"+fieldLoanpurpose+"')]//..//..//a[@class='select']")).click();
        driver.findElement(By.xpath("//div[@class='select-options']//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='"+loan_purpose+"']")).click();
        driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldExpdate+"']//..//..//input")).sendKeys(exp_date);

    }

    public void clickOnSave(WebDriver driver, String buttonName) {
        driver.findElement(By.xpath("//button[@title='" + buttonName + "']//span[@class=' label bBody']")).click();
    }

    public void againLeads(WebDriver driver, String fieldtab) {
        WebElement element1 = driver.findElement(By.xpath("//div[@class=\"slds-context-bar\"]//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']//..//a[@title='"+fieldtab+"']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);
    }

    public void leadsNameInSearch(WebDriver driver, String name) {
        String contactName = name;
        driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys(contactName);
        Actions act1 = new Actions(driver);
        act1.sendKeys(Keys.ENTER).build().perform();
    }

    public void searchLeadName(WebDriver driver) {
        WebElement e = driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//tbody"));
        List<WebElement> rows = e.findElements(By.tagName("tr"));
        WebElement firstRecordFound = rows.get(0);
        firstRecordFound.findElement(By.tagName("th")).findElement(By.tagName("a")).click();
    }

    public void displayedValues(WebDriver driver, String fieldCompany, String fieldWebsite, String fieldCIN, String fieldGroup, String fieldEmail, String fieldAnnual, String fieldOwnership, String fieldLeadstat, String fieldFirstName, String fieldLastName, String fieldIncop, String fieldStreet, String fieldCity, String fieldCountry, String fieldLoanName, String fieldAmount, String fieldLoanpurpose, String fieldExpdate, String company, String website, String cin, String group, String email, String annual, String ownership, String lead_status, String first_name, String last_name, String incop_date, String street, String city, String country, String loan_name, String amount, String loan_purpose, String exp_date) {
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCompany+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldWebsite+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCIN+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldEmail+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldAnnual+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldGroup+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldIncop+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldStreet+"']//..//..//textarea")).getText();
   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("javascript:window.scrollBy(0,200)");
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCity+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldCountry+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldFirstName+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldLastName+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldLoanName+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldAmount+"']//..//..//input")).getText();
   driver.findElement(By.xpath("//div[@class='full forcePageBlock forceRecordLayout']//label//span[text()='"+fieldExpdate+"']//..//..//input")).sendKeys(exp_date);
    }

    public void chargebackValues(WebDriver driver, String fieldChargebackBankAction, String fieldChargebackReceivedOn, String filedChargebackReferenceNumber, String filedChargebackResponseBy, String filedChargebackActualResponseDate, String filedChargebackSSTResponse, String filedChargebackBankFinalNotificationDate, String chargebackBankAction, String chargebackReceivedOn, String chargebackReferenceNumber, String chargebackResponseBy, String chargebackActualResponseDate, String chargebackSSTResponse, String chargebackBankFinalNotificationDate) {
     driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + fieldChargebackBankAction + "']")).click();
     driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + fieldChargebackBankAction + "']/..//span[@title='" + chargebackBankAction + "']")).click();
     driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + fieldChargebackReceivedOn + "']/..//input")).click();
     driver.findElement(By.xpath("//div[@class='slds-card__body']//td[@data-value='" + chargebackReceivedOn + "']")).click();
     driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + filedChargebackReferenceNumber + "']/..//input")).sendKeys(chargebackReferenceNumber);
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("scrollBy(0,200)");
     driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + filedChargebackResponseBy + "']/..//input")).click();
     driver.findElement(By.xpath("//div[@class='slds-card__body']//td[@data-value='" + chargebackResponseBy + "']")).click();
        driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + filedChargebackActualResponseDate + "']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackActualResponseDate + "']")).click();
        driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + filedChargebackSSTResponse + "']")).click();
        driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + filedChargebackSSTResponse + "']/..//span[@title='" + chargebackSSTResponse + "']")).click();
        driver.findElement(By.xpath("//div[@class='slds-card__body']//label[text()='" + filedChargebackBankFinalNotificationDate + "']/..//input")).click();
        driver.findElement(By.xpath("//td[@data-value='" + chargebackBankFinalNotificationDate + "']")).click();
    }

}
