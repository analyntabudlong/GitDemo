import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        //dropdown with select tag
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown =  new Select(staticDropdown);
        dropdown.selectByIndex(3); //USD
        //dropdown.selectByVisibleText("INR");//another way of selecting a currency
        //dropdown.selectByValue("AED");//another way of selecting a currency
        String currency = dropdown.getFirstSelectedOption().getText();
        System.out.println(currency);
        driver.close();
    }
}
