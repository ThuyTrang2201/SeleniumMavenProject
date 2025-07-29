package automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CommonBase {
    public static WebDriver driver;
    public WebDriver initChromeDriver(String Url)
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return driver;
    }
}




