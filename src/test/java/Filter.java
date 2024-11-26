import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.id("search-field"));
        search.sendKeys("Rice");
        //search.sendKeys(Keys.ENTER);
        List<WebElement> veggies = driver.findElements(By.xpath("//tr//td[1]"));

        //1 result
        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).
                collect(Collectors.toList());
        //1 result
        Assert.assertEquals(veggies.size(), filteredList.size());
    }
}
