package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TS_PracticeLocateElement_Bai2 extends CommonBase {
    // locator trường name
    @Test
    public void getElementById1()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement namelElement = driver.findElement(By.id("name"));
        System.out.println("namelElement:" + namelElement);
    }
    // locator trường address
    @Test
    public void getElementById2()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement addressElement = driver.findElement(By.id("address"));
        System.out.println("addressElement:" + addressElement);
    }
    // locator trường email
    @Test
    public void getElementById3()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement emailElement = driver.findElement(By.id("email"));
        System.out.println("emailElement:" + emailElement);
    }
    // locator trường password

    @Test
    public void getElementById4()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement passwordElement = driver.findElement(By.id("password"));
        System.out.println("passwordElement:" + passwordElement);
    }
}
