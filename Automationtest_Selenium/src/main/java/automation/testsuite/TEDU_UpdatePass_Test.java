package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertListContainsObject;
import static org.testng.Assert.assertTrue;

public class TEDU_UpdatePass_Test  extends CommonBase {
    TEDU_PageFactory tedu;
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.TEDU_URL);
        tedu = new TEDU_PageFactory(driver);
    }

    @Test
    public void loginSuccessfully() throws InterruptedException
    {
       tedu.loginFunction("thuytrang064p@gmail.com","123456");
       Thread.sleep(3000);
       assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
    }

    @Test
    public void updatePassSuccessfully() throws InterruptedException
    {
        loginSuccessfully();
        tedu.updatePassword("1234567","123456");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//div[@Class='alert alert-success']")).isDisplayed());
    }
// Search khóa học: Optional >> Khóa học DevOps
    @Test
    public void searchFunction() throws InterruptedException
    {
        loginSuccessfully();
        tedu.searchKhoahoc("Web API");
        Thread.sleep(5000);
        List<WebElement> titleSearchResults = driver.findElements(By.xpath("//div[@class='post-title']/h3/a"));
        List<WebElement> contentSearchResults = driver.findElements(By.xpath("//div[@class='post-title']/p"));
        System.out.println("titleSearchResults size:" + titleSearchResults.size());
        System.out.println("contentSearchResults size:" + contentSearchResults.size());
        for (WebElement titleElement : titleSearchResults)
        {
            String actualTitle = titleElement.getText();
            if (!actualTitle.contains("Web API"))
            {
                for (WebElement contentElement : contentSearchResults) {
                    String actualContent = contentElement.getText();
                    System.out.println("actualContent is:" + actualContent);
                     if (!actualContent.contains("Web API"))
                     {
                         assertTrue(actualContent.contains("Web API"));
                     }
                     else
                     {
                         assertTrue(actualContent.contains("WebAPI"));
                     }
                }
            }
                else
            {
                System.out.println("actualTitle is:" + actualTitle);
                assertTrue(actualTitle.contains("Web API"));
            }
        }
    }
    @AfterMethod
    public void closeDriver() {
        if (driver != null)
            driver.close();
    }
}




