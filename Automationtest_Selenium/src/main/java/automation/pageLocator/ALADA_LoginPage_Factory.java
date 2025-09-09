package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ALADA_LoginPage_Factory {
    private WebDriver driver;

    // Goi chu thich @Findby de tao lien ket giưa WebElement voi Locator
    @FindBy(id="txtLoginUsername") WebElement textEmail;
    @FindBy(id="txtLoginPassword") WebElement textPassword;
    @FindBy(xpath="(//button[text()='ĐĂNG NHẬP'])[3]") WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='avatar2']") WebElement imageAvatar;
    @FindBy(xpath="//a[text()='Thoát']")WebElement btnThoat;
    public ALADA_LoginPage_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void loginFunction(String email, String pass)
    {
        textEmail.sendKeys(email);
        textPassword.sendKeys(pass);
        buttonLogin.click();
    }
    public void logoutFunction()
    {
//        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
        imageAvatar.click();
        btnThoat.click();
    }
}
