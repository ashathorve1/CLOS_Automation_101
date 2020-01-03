package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;
    By appIcon=By.xpath("//div[@class='slds-icon-waffle']");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getAppIcon(){
        return driver.findElement(appIcon);
    }

    public void clickLeads(WebDriver driver, String filedTagname) {
        WebElement element1 = driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']//a[@title='"+filedTagname+"']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);
    }
}
