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

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void clickAdd(){
        waitForElement(30, "//button[text() = ' Add ']");
        driver.findElement(By.xpath("//button[text() = ' Add ']")).click();
    }

    public void setJobTitle(String jobTitle){
        waitForElement(30, "(//input[@class = 'oxd-input oxd-input--active'])[2]");
        driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]")).sendKeys(jobTitle);
    }

    public void setjobdescription(String jobDescription){
        waitForElement(30, "(//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]");
        driver.findElement(By.xpath("(//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical'])[1]")).sendKeys(jobDescription);
    }

    public void setJobFile(String filePath){
        waitForElement(30, "//div[@class='oxd-file-div oxd-file-div--active']");
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(filePath);
    }

    public void clickSave(){
        waitForElement(30, "//button[text() = ' Save ']");
        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    //===== VALIDATION STEPS =====//

    public void checkSuccess(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
