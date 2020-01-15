import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebTesting {

    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //.implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("http://gmail.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(title.length());
        /*
        *WebElement wElem = driver.findElement(By.xpath("//input[@id='identifierId']"));
        * wElem.sendKeys("pkarolidis69@gmail.com");
        * OR
         */

        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("selenium.periklis@gmail.com");
        /*
        wElem = driver.findElement(By.xpath("//div[@id='identifierNext']"));
        wElem.click();
        * OR
         */
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
        //System.out.println("HAHA " + driver.findElement(By.xpath("//input[@type='password']")).getTagName());
    //Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("PASOKmadeWORKS");

        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
        /*driver.close();
        driver = null;*/
    }
}
