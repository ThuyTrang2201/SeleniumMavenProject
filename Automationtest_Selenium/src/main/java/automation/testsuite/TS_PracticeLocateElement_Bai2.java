package automation.testsuite;

import automation.common.CT_PageURL;
import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TS_PracticeLocateElement_Bai2 extends CommonBase {
    @Test
    public void getElementById1()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement emailElement = driver.findElement(By.id("mail"));
        System.out.println("emailElement:" + emailElement);
    }

    @Test
    public void getElementById2()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement disable_passwordElement = driver.findElement(By.id("disable_password"));
        System.out.println("disable_passwordElement:" + disable_passwordElement);
    }

    @Test
    public void getElementById3()
    {
        driver = initChromeDriver(CT_PageURL.AUTOMATIONFC_URL);
        WebElement numberElement = driver.findElement(By.id("number"));
        System.out.println("numberElement:" + numberElement);
    }
}
