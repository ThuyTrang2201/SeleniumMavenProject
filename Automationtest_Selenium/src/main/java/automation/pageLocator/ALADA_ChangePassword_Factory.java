package automation.pageLocator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ALADA_ChangePassword_Factory {
    private WebDriver driver;



    // Login
    @FindBy(id="txtLoginUsername") WebElement textEmail;
    @FindBy(id="txtLoginPassword") WebElement textPassword;
    @FindBy(xpath="(//button[text()='ĐĂNG NHẬP'])[3]") WebElement buttonLogin;
    // Change Pass
    @FindBy(xpath = "//div[@class='avatar2']") WebElement imageAvatar;
    @FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']") WebElement editInfor;
    @FindBy(id = "txtpassword") WebElement textPass;
    @FindBy(id = "txtnewpass") WebElement textNewpass;
    @FindBy(id = "txtrenewpass") WebElement textRenewpass;
    @FindBy(xpath = "//button[text()='Lưu mật khẩu mới']") WebElement buttonSave;
    // Logout
    @FindBy(xpath = "//a[text()='Thoát']") WebElement buttonLogout;

    public ALADA_ChangePassword_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String pass)
    {
        textEmail.sendKeys(email);
        textPassword.sendKeys(pass);
        buttonLogin.click();
    }
    public void hoverAvatarLogin()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(imageAvatar).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editInfor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Chỉnh sửa thông tin']")));
        editInfor.click();
    }


    public void editPassFunction(String pass, String newpass, String renewpass)
    {

        textPass.sendKeys(pass);
        textNewpass.sendKeys(newpass);
        textRenewpass.sendKeys(renewpass);
        buttonSave.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        imageAvatar.click();
        buttonLogout.click();
    }

}
