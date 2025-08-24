package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class TEDU_UpdatePass_Test  extends CommonBase {
    TEDU_PageFactory tedu;
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.TEDU_URL);
        tedu = new TEDU_PageFactory(driver);
    }

    @Test
    public void loginSuccessfully() throws InterruptedException
    {
       tedu.loginFunction("thuytrang064p@gmail.com","123456");
       Thread.sleep(3000);
       assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
    }

    @Test
    public void updatePassSuccessfully() throws InterruptedException
    {
        loginSuccessfully();
        tedu.updatePassword("1234567","123456");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//div[@Class='alert alert-success']")).isDisplayed());
    }
// Search khóa học: Optional >> Khóa học DevOps
    @Test
    public void searchFunction() throws InterruptedException
    {
        loginSuccessfully();
        tedu.searchKhoahoc("DevOps");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//a[text()='Triển khai CI/CD với Azure DevOps']")).isDisplayed());
    }
}
