package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    WebDriver driver;

    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickAdd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() =  ' Add ']")));

        driver.findElement(By.xpath("//button[text() =  ' Add ']")).click();
    }

    public void AddProfilePicture(String picturePath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'oxd-file-div oxd-file-div--active']")));

        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(picturePath);
    }

    public void SetFirstName(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'firstName']")));

        driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys(firstName);
    }

    public void SetMiddleName(String middleName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'middleName']")));

        driver.findElement(By.xpath("//input[@name = 'middleName']")).sendKeys(middleName);
    }

    public void SetLastName(String lastName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'lastName']")));

        driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys(lastName);
    }

    public void SetId(String id){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")));

        driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")).sendKeys(id);
    }

    public void ThickCreateLoginDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']")));

        driver.findElement(By.xpath("//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']")).click();
    }

    public void SetUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[3]")));

        driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[3]")).sendKeys(username);
    }

    public void SetPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type = 'password'])[1]")));

        driver.findElement(By.xpath("(//input[@type = 'password'])[1]")).sendKeys(password);
    }

    public void SetConfirmPassword(String confirmPassword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type = 'password'])[2]")));

        driver.findElement(By.xpath("(//input[@type = 'password'])[2]")).sendKeys(confirmPassword);
    }

    public void CheckCreation(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-toast--success')]")));

            driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast--success')]")).isDisplayed();

    }
}
