package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;

import java.time.Duration;

public class ContactDetails {

    WebDriver driver;

    public ContactDetails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SetStreet1(String street){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")));

        driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")).click();
        driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")).clear();
        driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")).sendKeys(street);
    }

    public void SetCountry(String country){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-select-text-input')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text-input')]")).click();
        driver.findElement(By.xpath("//span[text()='"+ country +"']")).click();
    }

    public void ClickSave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@type, 'submit')]")));

        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();
    }

    public void CheckSuccess(){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-toast--success oxd-toast-container--toast')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast--success oxd-toast-container--toast')]")).isDisplayed();
    }

    public void ClickAddAttachment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@type, 'button')])[3]")));

        driver.findElement(By.xpath("(//button[contains(@type, 'button')])[3]")).click();
    }

    public void AddAttachmentFile(String filePath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-file-div')]")));

        driver.findElement(By.xpath("//input[contains(@type, 'file')]")).sendKeys(filePath);
    }

    public void AddAttachmentComment(String comment){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@class, 'textarea')]")));

        driver.findElement(By.xpath("//textarea[contains(@class, 'textarea')]")).sendKeys(comment);
    }

    public void ClickAttachmentSave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@type, 'submit')])[2]")));

        driver.findElement(By.xpath("(//button[contains(@type, 'submit')])[2]")).click();
    }

    public void CheckAttachment(String commentToCheck){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-table-cell.oxd-padding-cell")));


        driver.findElement(By.cssSelector("div.oxd-table-cell.oxd-padding-cell:nth-child(3)>div")).getText().contains(commentToCheck);
    }
}
