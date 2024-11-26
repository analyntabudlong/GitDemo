import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
1. Select any checkbox
2. Grab the label of the selected checkbox // put into variable
3. Select an option in dropdown. The option to select should come from step 2. // do not hard code text. Drive it dynamically from step 2.
4. Enter the step 2 grabbed label in Edit box.
5. Click Alert and then verify if grabbed text from step 2 is present in the pop up message.
 */


public class CodingAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        /*
        WebElement optionChk = driver.findElement(By.id("checkBoxOption2"));
        optionChk.click();
        String option = optionChk.getText();
        System.out.println(option);
        //dropdown with select tag
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown =  new Select(staticDropdown);
        dropdown.selectByValue(option);//select same option from checkbox

        WebElement enterName = driver.findElement(By.id("name"));
        enterName.sendKeys(option);

         */
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));

        Select s=new Select(dropdown);
        s.selectByVisibleText(opt);

        driver.findElement(By.name("enter-name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();

        String text=  driver.switchTo().alert().getText();

        if(text.contains(opt))
        {
            System.out.println("Alert message success");
        }
        else
            System.out.println("Something wrong with execution");

    }

}

