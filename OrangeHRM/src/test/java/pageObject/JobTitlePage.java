package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobTitlePage {

    WebDriver driver;

    public JobTitlePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickAdd(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = ' Add ']")));

        driver.findElement(By.xpath("//button[text() = ' Add ']")).click();
    }

    public void SetJobTitle(String jobTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")));

        driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")).sendKeys(jobTitle);
    }

    public void SetJobDescription(String jobDescription){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]")));

        driver.findElement(By.xpath("(//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]")).sendKeys(jobDescription);
    }

    public void SetJobFile(String filePath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-file-div oxd-file-div--active']")));

        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(filePath);
    }

    public void ClickSave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = ' Save ']")));

        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    public void CheckSuccess(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
