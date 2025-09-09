package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Day18_BTVN_Bepantoan extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(@Optional("Chrome") String browser) {
        driver = setupDriver(browser);
        driver.get(CT_PageURL.BEPANTOAN_URL);
    }

    @Test
    public void zaloContact() {
        WebElement zalochat = driver.findElement(By.xpath("(//span[text()='Chat với chúng tôi'])[2]"));
        String currentWindow = driver.getWindowHandle();
        zalochat.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("zalo.me"));
        String curentUrl = driver.getCurrentUrl();
        assertTrue(curentUrl.contains("https://zalo.me/0912331335"));
    }
}

