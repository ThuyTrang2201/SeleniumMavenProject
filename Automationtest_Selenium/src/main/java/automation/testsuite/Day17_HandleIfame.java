package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Day17_HandleIfame extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.CODESTAR_URL);
    }

    @Test
    public void handleIframe()
    {
        scrollToElement(By.xpath("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
        System.out.println("iframe total:" + driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        type(By.id("email"), "0121325454");
        clickByJS(By.xpath("//button[normalize-space()='Gửi ngay']"));
        assertTrue(isElementDisplay(By.id("email")));

    }
}
