import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebTesting {

    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {

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
        driver.get("http://gmail.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(title.length());
        /*
        *WebElement wElem = driver.findElement(By.xpath("//input[@id='identifierId']"));
        * wElem.sendKeys("pkarolidis69@gmail.com");
        * OR
         */
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("pkarolidis69@gmail.com");
        /*
        wElem = driver.findElement(By.xpath("//div[@id='identifierNext']"));
        wElem.click();
        * OR
         */
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pkarolidis69@gmail.com");
        /*driver.close();
        driver = null;*/
    }
}
