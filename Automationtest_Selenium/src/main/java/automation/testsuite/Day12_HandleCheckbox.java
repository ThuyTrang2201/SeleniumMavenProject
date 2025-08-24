package automation.testsuite;


import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Day12_HandleCheckbox extends CommonBase {

    @Test
    public void chooseHobbies()
    {
        driver= initChromeDriver(CT_PageURL.DEMOQA_URL);
        scrollToElement(By.id("userNumber"));
        WebElement sportLabel = driver.findElement(By.xpath("//label[text()='Sports']"));
        boolean isSportSelected = sportLabel.isSelected();
        if (isSportSelected==false)
        {
            sportLabel.click();
            System.out.println("Checkbox sport has been selected");
        }
        WebElement reading = driver.findElement(By.xpath("//label[text()='Reading']"));
        if (reading.isSelected()==false)
        {
            reading.click();
            System.out.println("Checkbox reading has been selected");
        }
        WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
        if (music.isSelected()==false)
        {
            music.click();
            System.out.println("Checkbox music has been selected");
        }
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}