package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Day12_HandleRadioButton extends CommonBase {
    @Test
    public void chooseMale() {
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        boolean rdoMale = radioMale.isSelected();
        // 1 Kiểm tra giá trị mặc định
        assertEquals(rdoMale, false);
        // 2 Click vào Male
        if (radioMale.isEnabled() == true) {
            radioMale.click();
            System.out.println("Radio male was clicked");
        }
    }
    @Test
    public void chooseFemale() {
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement radioFemale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        if(radioFemale.isEnabled()==true)
        {
            radioFemale.click();
            System.out.println("Radio Female was clicked");
        }
    }

    @Test
    public void chooseOther() {
        driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement radioOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        if(radioOther.isEnabled()==true)
        {
            radioOther.click();
            System.out.println("Radio Other was clicked");
        }
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
