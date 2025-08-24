package automation.testsuite;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPage_CodeStar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeworkDay13_LoginTest_CodeStar extends CommonBase {
    @BeforeMethod
    public void openFirefoxBrowser()
    {
        driver = initFireFoxDriver(CT_PageURL.CODESTAR_CRM_URL);
    }
    // Case 1: Login thành công
    @Test
    public void loginSuccessfully()
    {
        LoginPage_CodeStar login = new LoginPage_CodeStar(driver);
        login.LoginFunctionCodeStar("admin@gmail.com", "12345678");
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Quanlynguoidung = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[normalize-space()='Quản lý người dùng']")));
        assertTrue(Quanlynguoidung.isDisplayed());
    }

    // Case 2: Login failed do sai email
    @Test
    public void LoginfailedWrongEmail()
    {
        LoginPage_CodeStar login = new LoginPage_CodeStar(driver);
        login.LoginFunctionCodeStar("admin@gmail", "12345678");
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Email hoặc mật khẩu không đúng']")));
        assertTrue(errorMessage.isDisplayed());
    }

    //Case 3: Login failed do sai password
    @Test
    public void LoginfailedWrongPass()
    {
        LoginPage_CodeStar login = new LoginPage_CodeStar(driver);
        login.LoginFunctionCodeStar("admin@gmail.com", "12345");
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Email hoặc mật khẩu không đúng']")));
        assertTrue(errorMessage.isDisplayed());
    }

    // Case 4: Login failed do sai email và pass
    @Test
    public void LoginfailedWrongEmailandPass()
    {
        LoginPage_CodeStar login = new LoginPage_CodeStar(driver);
        login.LoginFunctionCodeStar("admin@gmail", "12345");
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Email hoặc mật khẩu không đúng']")));
        assertTrue(errorMessage.isDisplayed());
    }

    // Case 5: Logout
    @Test
     public void Logout() {
        LoginPage_CodeStar login = new LoginPage_CodeStar(driver);
        login.LoginFunctionCodeStar("admin@gmail.com", "12345678");
        handleInsecurePopup();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Quanlynguoidung = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[normalize-space()='Quản lý người dùng']")));
        assertTrue(Quanlynguoidung.isDisplayed());
        WebElement adminDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("dropdownMenuLink")));
        adminDropdown.click();
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[text()='Đăng xuất'])[1]")));
        logoutButton.click();
        WebElement sumitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[text()='Đăng xuất'])[2]")));
        sumitButton.click();
        assertEquals(driver.getCurrentUrl(), "https://test-system.crmstar.vn/");
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
