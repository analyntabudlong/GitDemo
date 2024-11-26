import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

public class eCommerceArray {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String[] veggies = {"Brocolli", "Tomato", "Capsicum"};
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;

        for (int i=0; i<products.size();i++)
        {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            List veggiesList = Arrays.asList(veggies);
            if (veggiesList.contains(formattedName))
            {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

                if (j==veggies.length)
                {
                    break;
                }
            }
        }
        Thread.sleep(2000);
        driver.close();

    }
}
