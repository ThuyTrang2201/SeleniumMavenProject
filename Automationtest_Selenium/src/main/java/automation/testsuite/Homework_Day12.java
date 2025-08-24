package automation.testsuite;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Homework_Day12 extends CommonBase {
    @Test
    // Chọn 1 trong các Option của dropdownlist Select Country
    public void selectCountry() {
        driver = initChromeDriver(CT_PageURL.GLOBALSQ_URL);
        WebElement chooseCountry = driver.findElement(By.xpath("//select"));
        Select countrySelect = new Select(chooseCountry);
        countrySelect.selectByVisibleText("Viet Nam");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualText1 = countrySelect.getFirstSelectedOption().getText();
        assertEquals(actualText1, "Viet Nam");
    }
    // có thể tìm theo index

}