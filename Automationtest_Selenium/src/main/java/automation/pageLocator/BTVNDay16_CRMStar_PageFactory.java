package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BTVNDay16_CRMStar_PageFactory {
    private WebDriver driver;
   // find element chức năng login
    @FindBy(id="email") WebElement txtEmail;
    @FindBy(id = "password") WebElement txtPassword;
    @FindBy(xpath = "//button[@class = 'btn btn-success']") WebElement btnDangnhap;

    // find element chức năng Thêm mới klv
    @FindBy(xpath= "(//a[normalize-space(text()='Quản lý khu làm việc')])[6]")
    WebElement tabQuanlykhulamviec;
    @FindBy(xpath = "//button[text()='Thêm mới']") WebElement btnThemmoi;
    @FindBy(xpath = "(//input[@class='form-control'])[1]") WebElement txtMaKVLV;
    @FindBy(xpath = "(//input[@class='form-control'])[2]") WebElement txtTenKVLV;

    // find element xóa klv vừa thêm thành công
    @FindBy(xpath = "//input[@placeholder='Nhập từ khóa cần tìm kiếm']") WebElement txtSearch;
    @FindBy(xpath = "//button[text()='Tìm kiếm']") WebElement btnSearch;
    @FindBy(xpath = "(//a[@class='btn btn-success'])[3]") WebElement btnDelete;

    public BTVNDay16_CRMStar_PageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void loginFunction(String email, String pass)
    {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(pass);
        btnDangnhap.click();
    }

    public void themKhulamviec(String maKVLV, String tenKVLV) {
        tabQuanlykhulamviec.click();
        btnThemmoi.click();
        txtMaKVLV.sendKeys(maKVLV);
        txtTenKVLV.sendKeys(tenKVLV);
        txtTenKVLV.sendKeys(Keys.ENTER);
    }

    public void searchvaxoaKhulamviec(String tenKVLV)
    {
        txtSearch.sendKeys(tenKVLV);
        btnSearch.click();
        btnDelete.click();
    }

}
