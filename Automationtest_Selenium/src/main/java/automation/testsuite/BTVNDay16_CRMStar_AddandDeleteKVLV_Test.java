package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.BTVNDay16_CRMStar_PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BTVNDay16_CRMStar_AddandDeleteKVLV_Test extends CommonBase {
    String tenKVLV = "Phòng quản lý dự án";
    String maKVLV = "KV150";
    @BeforeMethod
    public void openFirefoxBrowser()
    {
        driver = initFireFoxDriver(CT_PageURL.CODESTAR_CRM_URL);
    }

    @Test
    public void loginSuccess()
    {
        BTVNDay16_CRMStar_PageFactory factory = new BTVNDay16_CRMStar_PageFactory(driver);
        factory.loginFunction("admin@gmail.com", "12345678");
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Quanlynguoidung = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[normalize-space()='Quản lý người dùng']")));
        assertTrue(Quanlynguoidung.isDisplayed());
    }

    @Test
    public void addanddeleteKVLV() throws InterruptedException
    {
        loginSuccess();
        BTVNDay16_CRMStar_PageFactory factory = new BTVNDay16_CRMStar_PageFactory(driver);
        factory.themKhulamviec(maKVLV, tenKVLV);
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[normalize-space()='Thêm mới khu vực làm việc thành công']")));
        assertTrue(messSuccess.isDisplayed());
        Thread.sleep(3000);
        factory.searchvaxoaKhulamviec(tenKVLV);
        Thread.sleep(3000);
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Bạn có thực sự muốn xóa khu vực này");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//div[normalize-space()='Xóa khu vực làm việc thành công']")));
        Thread.sleep(3000);

    }

}
