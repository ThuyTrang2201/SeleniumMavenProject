package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TS_PracticeLocateElement_Bai1 extends CommonBase {
    @Test
     public void getElementByName1()
    {
        driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
        WebElement emailElement = driver.findElement(By.name("email"));
        System.out.println("emailElement:" + emailElement);
    }

    @Test
    public void getElementById()
    {
        driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
        WebElement passElement = driver.findElement(By.id("pass"));
        System.out.println("passElement:" + passElement);
    }

    @Test
    public void getElementByName2()
    {
        driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
        WebElement companyElement= driver.findElement(By.name("company"));
        System.out.println("companyElement:" + companyElement);
    }
    @Test
    public void getElementByName3()
    {
        driver = initChromeDriver(CT_PageURL.SELECTOR_HUB_URL);
        WebElement mobile_numberElement= driver.findElement(By.name("mobile number"));
        System.out.println("mobile_numberElement:" + mobile_numberElement);
    }

}