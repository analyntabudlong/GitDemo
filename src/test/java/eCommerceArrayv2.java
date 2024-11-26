import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class eCommerceArrayv2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Implicit Wait
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));//Explicit Wait

        String[] veggies = {"Brocolli", "Tomato", "Capsicum"};
        WebElement addToCartBtn = driver.findElement(By.cssSelector("img[alt='Cart']"));
        WebElement proceedBtn = driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
        //WebElement promoCode = driver.findElement(By.cssSelector("input.promoCode"));
        //WebElement applyBtn = driver.findElement(By.className("promoBtn"));
        //WebElement message = driver.findElement(By.className("promoInfo"));

        addItems(driver, veggies);
        addToCartBtn.click();
        proceedBtn.click();
        //Thread.sleep(2000);
        //Explicit Wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());

        Thread.sleep(2000);
        driver.close();

    }

    public static void addItems(WebDriver driver,String[] veggies )
    {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

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
    }
}
