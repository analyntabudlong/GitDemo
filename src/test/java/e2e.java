import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//Note: As of 10/30/24, select for Date is not working. Manually select if first during test run.

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement oneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
        WebElement from =  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        WebElement to =  driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        //WebElement departDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
        WebElement paxInfo =  driver.findElement(By.id("divpaxinfo"));
        WebElement adult = driver.findElement(By.id("hrefIncAdt"));
        WebElement doneBtn = driver.findElement(By.id("btnclosepaxoption"));
        WebElement ffChkBox = driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']"));
        WebElement submitBtn = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));

        from.click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        Thread.sleep(4000);
        //departDate.click();
        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        //driver.findElement(By.className("ui-state-default.ui-state-highlight.ui-state-active")).click();

        paxInfo.click();
        Thread.sleep(2000);
        for (int i = 1; i < 5; i++)
        {
            adult.click();
        }

        Assert.assertEquals(paxInfo.getText(), "5 Adult");

        Thread.sleep(3000);
        doneBtn.click();
        ffChkBox.click();
        Assert.assertTrue(ffChkBox.isSelected());

        //dropdown with select tag - Currency
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown =  new Select(staticDropdown);
        dropdown.selectByIndex(3); //USD

        submitBtn.click();
        Thread.sleep(2000);
        driver.close();

    }
}
