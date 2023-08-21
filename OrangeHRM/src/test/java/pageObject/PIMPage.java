package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void clickAdd() {
        waitForElement(30, "//button[text() =  ' Add ']");
        driver.findElement(By.xpath("//button[text() =  ' Add ']")).click();
    }

    public void addProfilePicture(String picturePath){
        waitForElement(30, "//div[@class = 'oxd-file-div oxd-file-div--active']");
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(picturePath);
    }

    public void setFirstName(String firstName){
        waitForElement(30, "//input[@name = 'firstName']");
        driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys(firstName);
    }

    public void setMiddleName(String middleName){
        waitForElement(30, "//input[@name = 'middleName']");
        driver.findElement(By.xpath("//input[@name = 'middleName']")).sendKeys(middleName);
    }

    public void setLastName(String lastName){
        waitForElement(30, "//input[@name = 'lastName']");
        driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys(lastName);
    }

    public void setId(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitForElement(30, "(//input[@class = 'oxd-input oxd-input--active'])[2]");
        WebElement element1  = driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]"));
        js.executeScript("arguments[0].value = '" + id + "';", element1);
    }

    public void thickCreateLoginDetails(){
        waitForElement(30, "//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']");
        driver.findElement(By.xpath("//span[@class = 'oxd-switch-input oxd-switch-input--active --label-right']")).click();
    }

    public void setUsername(String username){
        waitForElement(30, "(//input[@class = 'oxd-input oxd-input--active'])[3]");
        driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[3]")).sendKeys(username);
    }

    public void setPassword(String password){
        waitForElement(30, "(//input[@type = 'password'])[1]");
        driver.findElement(By.xpath("(//input[@type = 'password'])[1]")).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        waitForElement(30, "(//input[@type = 'password'])[2]");
        driver.findElement(By.xpath("(//input[@type = 'password'])[2]")).sendKeys(confirmPassword);
    }

    //===== VALIDATION STEPS =====//

    public void checkCreation(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast--success')]")).isDisplayed();
    }
}
