package automation.testsuite;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Day12_Dropdownlist extends CommonBase {
    @Test
    public void hanldeDropdownlist()
    {
        driver = initChromeDriver(CT_PageURL.CODESTART_URL);
        WebElement dropCatg = driver.findElement(By.id("product_categories_filter"));
        Select catgSelect = new Select(dropCatg);
        // 0 Kiểm tra số lượng Option
        int size = catgSelect.getOptions().size();
        assertEquals(size,5);
        // 1 Chọn AWS option bằng hàm selectByVisibleText
        catgSelect.selectByVisibleText("AWS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText1 = catgSelect.getFirstSelectedOption().getText();
        assertEquals(actualText1,"AWS");
        //2 Chọn Lập trình web bằng hàm SelectByValue
        catgSelect.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText2 = catgSelect.getFirstSelectedOption().getText();
        assertEquals(actualText2,"Lập trình web");
        //3 Chọn Programming course bằng index
        catgSelect.selectByIndex(4);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText3 = catgSelect.getFirstSelectedOption().getText();
        assertEquals(actualText3, "Programming courses");
    }
}
