package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.ALADA_LoginPage_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ALADA_LoginLogoutTest extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initFireFoxDriver(CT_PageURL.ALADA_URL);
    }

    @Test
    public void loginSuccessfully()
    {
        ALADA_LoginPage_Factory factory = new ALADA_LoginPage_Factory(driver);
        factory.loginFunction("thuytrang064p@gmail.com", "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test
    public void logoutSuccessfully()
    {
        loginSuccessfully();
        ALADA_LoginPage_Factory factory = new ALADA_LoginPage_Factory(driver);
        factory.logoutFunction();
        assertTrue(driver.findElement(By.xpath("//div[@class='login']")).isDisplayed());
    }
}

