package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public static final String ERROR_MSG="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    public static final String VALID_USERNAME="suma.srinivasaiah@centelon.com.clos2";
    public static final String VALID_PASSWORD="Test@123";

    By username=By.xpath("//input[@id='username']");
    By password=By.xpath("//input[@id='password']");
    By loginBtn=By.xpath("//input[@id='Login']");
    By rememberMe=By.xpath("//input[@id='rememberUn']");
    By forgotPwd=By.xpath("//a[@id='forgot_password_link']");
    By error=By.xpath("//div[@id='error']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    public WebElement getUsername(){
        return driver.findElement(username);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getLoginBtn(){
        return driver.findElement(loginBtn);
    }

    public WebElement getrememberMe(){
        return driver.findElement(rememberMe);
    }

    public WebElement getForgotPwd(){
        return driver.findElement(forgotPwd);
    }

    public WebElement getError(){
        return driver.findElement(error);
    }

    public String getErrorText(){
        return ERROR_MSG;
    }

    public String getValidUsername(){ return  VALID_USERNAME; }

    public  String getValidPassword(){ return VALID_PASSWORD; }
}
