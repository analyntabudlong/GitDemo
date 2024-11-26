import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        WebElement from =  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        WebElement to =  driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        //WebElement toDest = driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));

        /*
        from.click();
        from.sendKeys("Delhi");
        from.sendKeys(Keys.RETURN);
        */
        from.click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();


        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        //Used index in the xpath because there are 2 elements with the same locator in the page.
        //The other one is from the 'From' dropdown.

        //Parent-child traverse way instead of using index
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

    }
}
