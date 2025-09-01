package automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class CommonBase {
    public static WebDriver driver;

    public WebDriver initChromeDriver(String Url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().fullscreen();
        return driver;
    }

    public WebDriver initFireFoxDriver(String Url) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("security.warn_submit_insecure", false);
        options.addPreference("security.insecure_field_warning.contextual.enabled", false);
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().fullscreen();
        return driver;

    }

    public void handleInsecurePopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = getElementPresentDOM(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getElementPresentDOM(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Wrap phuong thuc isDisplay
    public boolean isElementDisplay (By locator) {
        try {
            WebElement element = getElementPresentDOM(locator);
            return element.isDisplayed();
        }
        catch (NoSuchElementException ex1) {
            return false;
        }
        catch (TimeoutException ex2) {
            return false;
        }
        catch (Exception ex) {
            return false;
        }
    }
    // Wrap phuong thuc click bang isElementTobeClickale
    public void click(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = getElementPresentDOM(locator);
        element.click();
    }
    // Wrap phuong thuc type
    public void type (By locator, String value)
    {
        WebElement element = getElementPresentDOM(locator);
        element.clear();
        element.sendKeys(value);
    }


    @AfterMethod
    public void closeDriver() {
        if (driver != null)
            driver.close();
    }
}




