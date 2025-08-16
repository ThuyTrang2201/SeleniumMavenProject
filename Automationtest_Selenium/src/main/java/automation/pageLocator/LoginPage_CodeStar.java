package automation.pageLocator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_CodeStar {
    private WebDriver driver;

    public LoginPage_CodeStar(WebDriver driver) {
        this.driver = driver;
    }
    public void LoginFunctionCodeStar (String email, String pass) {
        WebElement textEmail = driver.findElement(By.id("email"));
        if (textEmail.isDisplayed()) {
            textEmail.sendKeys(email);
        }
        WebElement textPassword = driver.findElement(By.id("password"));
        if (textPassword.isDisplayed()) {
            textPassword.sendKeys(pass);
        }
        WebElement buttonDangnhap = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        if (buttonDangnhap.isEnabled()) {
            buttonDangnhap.click();
        }
    }

}
