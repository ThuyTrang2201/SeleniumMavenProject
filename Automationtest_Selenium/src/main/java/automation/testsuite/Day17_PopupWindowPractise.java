package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day17_PopupWindowPractise extends CommonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.GURU99_URL);
    }

    @Test
    public void handleWindow()
    {
        String mainWindow =  driver.getWindowHandle();
//        click(By.xpath("//a[text()='Click Here']"));
        Set<String> listWindows = driver.getWindowHandles();
        for (String window : listWindows)
        {
            if(!mainWindow.equals(window))
            {
                driver.switchTo().window(window);
                assertTrue(isElementDisplay(By.xpath("//h2[contains(text(), 'Enter your email address to get ')]")));
                type(By.name("emailid"), "testEmail@gmail.com");
//                click(By.name("btnLogin"));
                assertTrue(isElementDisplay(By.xpath("//h2[text()='Access details to demo site.']")));
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        String currentURL = driver.getCurrentUrl();
        assertEquals(currentURL, "https://demo.guru99.com/popup.php");

    }
}
