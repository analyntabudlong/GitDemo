import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        WebElement paxInfo =  driver.findElement(By.id("divpaxinfo"));
        WebElement adult = driver.findElement(By.id("hrefIncAdt"));
        WebElement doneBtn = driver.findElement(By.id("btnclosepaxoption"));
        WebElement seniorDiscChkBox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));

        paxInfo.click();
        Thread.sleep(2000);

        int i = 1;
        while(i<5)
        {
            adult.click();
            i++;
        }

        /*
        for (int i = 1; i < 5; i++)
        {
            adult.click();
        }
         */
        Assert.assertEquals(paxInfo.getText(), "5 Adult");

        Thread.sleep(3000);
        doneBtn.click();

        Assert.assertFalse(seniorDiscChkBox.isSelected());

        seniorDiscChkBox.click();

        System.out.println(seniorDiscChkBox.isSelected());

        Assert.assertTrue(seniorDiscChkBox.isSelected());

        driver.close();
    }


}
