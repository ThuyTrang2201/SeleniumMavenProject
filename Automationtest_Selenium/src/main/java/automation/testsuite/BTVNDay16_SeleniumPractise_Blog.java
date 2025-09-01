package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BTVNDay16_SeleniumPractise_Blog extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.SELENIUMBLOG_URL);
    }

    @Test
    public void HandleAlertOk()
    {
        click(By.xpath("//button[text()='Try it']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actual = driver.switchTo().alert().getText();
        Assert.assertEquals(actual, "Welcome to Selenium WebDriver Tutorials");
        driver.switchTo().alert().accept();
    }

}
