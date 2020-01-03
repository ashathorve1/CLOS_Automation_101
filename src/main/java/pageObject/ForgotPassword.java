package pageObject;

import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    public WebDriver driver;

    public static final String PAGE_TITLE="Forgot Your Password | Salesforce";

    public ForgotPassword(WebDriver driver){
        this.driver=driver;
    }

    public String pageTitle(){
        return driver.getTitle().trim();
    }
}
