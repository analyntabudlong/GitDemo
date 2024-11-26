import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class actionsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://genweb-sit.cpi.com.ph:8080/Geniisys/");
        driver.manage().window().maximize();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));//Explicit Wait
        //Thread.sleep(3000);
        //Explicit Wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("forgotPassword")));
        WebElement forgotPword = driver.findElement(By.id("forgotPassword"));
        Actions a =  new Actions(driver);
        a.moveToElement(forgotPword).build().perform();


    }
}
