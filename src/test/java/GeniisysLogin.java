import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GeniisysLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://genweb-sit.cpi.com.ph:8080/Geniisys/");
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));//Explicit Wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("userId")));

        WebElement userName = driver.findElement(By.name("userId"));
        WebElement pword = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("loginButton"));

        userName.sendKeys("ANA");
        pword.sendKeys("ANA123456!");
        submitBtn.click();
        //Thread.sleep(3000);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("iconUnderwriting")));

        WebElement uwIcon = driver.findElement(By.id("iconUnderwriting"));
        uwIcon.click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("policyIssuance")));

        WebElement polIssuanceMenu = driver.findElement(By.id("policyIssuance"));
        WebElement polCreatePAR = driver.findElement(By.id("parCreation"));

        polIssuanceMenu.click();
        polIssuanceMenu.click();
        polCreatePAR.click();
        //driver.close();
    }
}
