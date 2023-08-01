package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactDetailsPage {

    WebDriver driver;

    public ContactDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void SetStreet1(String street){
        waitForElement(30, "(//input[contains(@class, 'oxd-input oxd-input--active')])[2]");
        driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")).click();
        driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")).clear();
        driver.findElement(By.xpath("(//input[contains(@class, 'oxd-input oxd-input--active')])[2]")).sendKeys(street);
    }

    public void SetCountry(String country){
        waitForElement(30, "//div[contains(@class, 'oxd-select-text-input')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-select-text-input')]")).click();
        driver.findElement(By.xpath("//span[text()='"+ country +"']")).click();
    }

    public void ClickSave(){
        waitForElement(30, "//button[contains(@type, 'submit')]");
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();
    }

    public void CheckSuccess(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast--success oxd-toast-container--toast')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast--success oxd-toast-container--toast')]")).isDisplayed();
    }

    public void ClickAddAttachment(){
        waitForElement(30, "(//button[contains(@type, 'button')])[3]");
        driver.findElement(By.xpath("(//button[contains(@type, 'button')])[3]")).click();
    }

    public void AddAttachmentFile(String filePath){
        waitForElement(30, "//div[contains(@class, 'oxd-file-div')]");
        driver.findElement(By.xpath("//input[contains(@type, 'file')]")).sendKeys(filePath);
    }

    public void AddAttachmentComment(String comment){
        waitForElement(30, "//textarea[contains(@class, 'textarea')]");
        driver.findElement(By.xpath("//textarea[contains(@class, 'textarea')]")).sendKeys(comment);
    }

    public void ClickAttachmentSave(){
        waitForElement(30, "(//button[contains(@type, 'submit')])[2]");
        driver.findElement(By.xpath("(//button[contains(@type, 'submit')])[2]")).click();
    }

    public void CheckAttachment(String commentToCheck){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-table-cell.oxd-padding-cell")));

        driver.findElement(By.cssSelector("div.oxd-table-cell.oxd-padding-cell:nth-child(3)>div")).getText().contains(commentToCheck);
    }

    public void SelectRecord(){
        waitForElement(30, "//div[contains(@class, 'oxd-table')]");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        waitForElement(30, "(//span[contains(@class, 'checkbox')])[2]");
        driver.findElement(By.xpath("(//span[contains(@class, 'checkbox')])[2]")).click();
    }

    public void DeleteRecord(){
        waitForElement(30, "//i[contains(@class, 'oxd-icon bi-trash-fill')]");
        driver.findElement(By.xpath("//i[contains(@class, 'oxd-icon bi-trash-fill')]")).click();
    }

    public void ConfirmDeletion(){
        waitForElement(30, "//button[text() = ' Yes, Delete ']");

        driver.findElement(By.xpath("//button[text() = ' Yes, Delete ']")).click();
    }

    public void CheckDeletion(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast--success')]");

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast--success')]")).isDisplayed();
    }
}
