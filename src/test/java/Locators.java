import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        /*driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium Locators");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        */
        driver.get("https://www.saucedemo.com/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        WebElement swagLogo = driver.findElement(By.className("login_logo"));
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement pword = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        //WebElement errorMsg = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username')]"));
        //WebElement errMsg = driver.findElement(By.xpath ("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
        /*
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
         */
        System.out.println(swagLogo.getText());
        Assert.assertEquals(swagLogo.getText(), "Swag Labs");
        userName.sendKeys("standard_user");
        pword.sendKeys("secret_sauce");//valid
        //pword.sendKeys("abc");//invalid
        //Thread.sleep(5000);
        //System.out.println(errorMsg);
        loginBtn.click();
        //driver.close();

    }
}
