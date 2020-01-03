package navigation;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class NavigateTo {
    public WebDriver driver;
    public ChromeOptions options;
    public WebDriver driver1;

    public WebDriver logintoSalesforce(){
        String CLOS_URL = getConfigurationDetails("webdriver.base.url");
        String CHROME_DRIVER=getConfigurationDetails("webdriver.name.chrome");
        String CHROME_EXE_FILE=getConfigurationDetails("webdriver.chrome.driver");
        String userName = getConfigurationDetails("clos.valid.username");
        String passWord = getConfigurationDetails("clos.valid.password");
        System.setProperty(CHROME_DRIVER,CHROME_EXE_FILE);
        options=new ChromeOptions();
        options.addArguments(getConfigurationDetails("disable_notifications"));
        driver1=new ChromeDriver(options);
        driver1.get(CLOS_URL);
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver1.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
        driver1.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
        driver1.findElement(By.xpath("//input[@id='Login']")).click();
        return driver1;
    }

    public WebDriver initializeDriver(){
        String CLOS_URL = getConfigurationDetails("webdriver.base.url");
        String CHROME_DRIVER=getConfigurationDetails("webdriver.name.chrome");
        String CHROME_EXE_FILE=getConfigurationDetails("webdriver.chrome.driver");
        System.setProperty(CHROME_DRIVER,CHROME_EXE_FILE);
        options=new ChromeOptions();
        options.addArguments(getConfigurationDetails("disable_notifications"));
        driver=new ChromeDriver(options);
        driver.get(CLOS_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }
    public void waitfortheelement() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
