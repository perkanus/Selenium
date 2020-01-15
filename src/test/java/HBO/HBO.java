package HBO;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HBO {
    public static WebDriver driver;
    static HBOProperties hboProperties;

    public static void main(String[] args) throws InterruptedException {
        try {
            hboProperties = new HBOProperties();
        } catch (IOException e)
        {

        }

        if (hboProperties.config.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (hboProperties.config.getProperty("browser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (hboProperties.config.getProperty("browser").equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.get(hboProperties.config.getProperty("siteURL"));
        if(Boolean.parseBoolean(hboProperties.config.getProperty("fullscreen")))
            driver.manage().window().maximize();
        HBO objHBO = new HBO();
        objHBO.LogIn(Boolean.parseBoolean(hboProperties.objectRepository.getProperty("rememberMe")));

    }
    public void LogIn(boolean rememberMe){
        // Not sure if it works with Chrome
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hboProperties.objectRepository.getProperty("logInLink_XPATH"))));
        // Logga in länk
        driver.findElement(By.xpath(hboProperties.objectRepository.getProperty("logInLink_XPATH"))).click();

        // E-mail
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hboProperties.objectRepository.getProperty("userName_XPATH"))));
        driver.findElement(By.xpath(hboProperties.objectRepository.getProperty("userName_XPATH"))).sendKeys(hboProperties.config.getProperty("username"));

        // Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hboProperties.objectRepository.getProperty("password_XPATH"))));
        driver.findElement(By.xpath(hboProperties.objectRepository.getProperty("password_XPATH"))).sendKeys(hboProperties.config.getProperty("password"));

        // Kom ihåg mig
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hboProperties.objectRepository.getProperty("rememberMe_XPATH"))));
        if (rememberMe == false)
        {
            // In Chrome at least send SPACE instead of using click
            driver.findElement(By.xpath(hboProperties.objectRepository.getProperty("rememberMe_XPATH"))).sendKeys(Keys.SPACE);
        }
//<button data-automation="adult-profile-button" aria-label="Serier &amp; Filmer" class="_2gkQI"><div aria-hidden="true" class="_3o0LK"><img src="https://apps.hbonordic.com/webapp/v3.11.7/images/tenant/hbon-main-profile.png" alt="Serier &amp; Filmer"></div></button>
//<button data-automation="family-profile-button" aria-label="Toonix Kids" class="_2gkQI"><div aria-hidden="true" class="_3o0LK"><img src="https://apps.hbonordic.com/webapp/v3.11.7/images/tenant/hbon-kids-profile.png" alt="Toonix Kids"></div></button>
        // Logga in knapp
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hboProperties.objectRepository.getProperty("logInButton_XPATH"))));
        driver.findElement(By.xpath(hboProperties.objectRepository.getProperty("logInButton_XPATH"))).click();
    }
    public void LogOut(){}
}
