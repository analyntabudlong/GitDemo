import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        WebElement frame1 = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame1);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();
        driver.close();

    }

}
