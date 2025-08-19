package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.ALADA_ChangePassword_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ALADA_ChangePassword_Test extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.ALADA_URL);
    }
    @Test
    public void loginSuccess()
    {
        ALADA_ChangePassword_Factory factory = new ALADA_ChangePassword_Factory(driver);
        factory.loginFunction("thuytrang064p@gmail.com", "test1234");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }
    @Test
    public void changePass()
    {
        loginSuccess();
        ALADA_ChangePassword_Factory factory = new ALADA_ChangePassword_Factory(driver);
        factory.hoverAvatar();
        factory.editPassFunction("test1234","123456","123456");
        assertEquals(driver.getCurrentUrl(),"https://alada.vn/thong-tin-ca-nhan");
    }
}
