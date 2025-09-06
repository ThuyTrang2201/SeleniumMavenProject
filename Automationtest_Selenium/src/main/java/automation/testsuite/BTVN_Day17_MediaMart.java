package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class BTVN_Day17_MediaMart extends CommonBase {

    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.MEDIAMART_URL);

    }

    @Test
    public void handleIframeZalo()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.easychatbot-widget")));
        WebElement closeBtn = (WebElement) js.executeScript(
                        "return arguments[0].shadowRoot.querySelector('button.flex.overflow-hidden.relative.justify-center.items-center.w-5.h-5.rounded-full.duration-500.hover\\\\:opacity-70')",
                shadow);
        closeBtn.click();
        WebElement chat = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("logo")));
        chat.click();
        assertTrue(isElementDisplay(By.xpath("//div[text()='Chat bằng Zalo']")));
    }

}
