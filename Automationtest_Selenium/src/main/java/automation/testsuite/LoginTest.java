package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import automation.pageLocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonBase {
    @BeforeMethod
   public void openChromeBrowser()
    {
        driver = initChromeDriver(CT_PageURL.ALADA_URL);
    }

    //Case 1: Login thành công
    @Test
    public void loginSuccessfully()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thuytrang064p@gmail.com", "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }
    // Login failed nhập sai email
    @Test
    public void loginFailed1()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thuytrang064p@gmail", "123456");
        WebElement Emailchuadangky = driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']"));
        assertTrue(Emailchuadangky.isDisplayed());
    }
    // Login failed để trống field email và password
    @Test
    public void loginFailed2()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("", "");
        WebElement nhapEmail = driver.findElement(By.xpath("//label[text()='Vui lòng nhập email']"));
        assertTrue(nhapEmail.isDisplayed());
        WebElement nhapPass = driver.findElement(By.xpath("//label[text()='Vui lòng nhập mật khẩu']"));
        assertTrue(nhapPass.isDisplayed());
    }
    // Login failed nhập sai password
    @Test
    public void loginFailed3()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("thuytrang064p@gmail.com", "12345667");
        WebElement Matkhausai = driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']"));
        assertTrue(Matkhausai.isDisplayed());
    }
}
