package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_PageFactory {
    private WebDriver driver;
    @FindBy(id="UserName") WebElement textEmail;
    @FindBy(id="Password") WebElement textPass;
    @FindBy(xpath="//button[text()='Đăng nhập']") WebElement buttonDN;
    @FindBy(id="onesignal-slidedown-allow-button") WebElement buttonSubcribe;
    @FindBy(id="my_account") WebElement buttonMyAccount;
    @FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement buttonChangePass;
    @FindBy(id="OldPassword") WebElement textOldPassword;
    @FindBy(id="NewPassword") WebElement textNewPassword;
    @FindBy(id="ConfirmNewPassword") WebElement textEConfirmNewPassword;
    @FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnCapNhat;
    // Chức năng Search
    @FindBy(xpath = "//input[@placeholder='Tìm bất cứ thứ gì mà bạn muốn']") WebElement textSearch;
    @FindBy(xpath = " //button[@type='submit']")  WebElement buttonSubmit;

    public TEDU_PageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction( String email, String pass)
    {
        textEmail.sendKeys(email);
        textPass.sendKeys(pass);
        buttonDN.click();
    }

    //js.executeScript("document.getElementById('id_of_element').click();");
    public void updatePassword (String oldPass, String newPass) throws InterruptedException
    {
        Thread.sleep(2000);
        buttonSubcribe.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('my_account').click();");
//        buttonMyAccount.click();
        js.executeScript("arguments[0].click();", buttonChangePass);
//        buttonChangePass.click();
        Thread.sleep(2000);
        textOldPassword.sendKeys(oldPass);
        textNewPassword.sendKeys(newPass);
        textEConfirmNewPassword.sendKeys(newPass);
        btnCapNhat.click();
    }

    public void searchKhoahoc(String text) throws InterruptedException
    {
        Thread.sleep(2000);
        buttonSubcribe.click();
        textSearch.sendKeys(text);
        buttonSubmit.click();
    }
}
