package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage {

    WebDriver driver;

    public LeavePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void ClickDotsUser(){
        waitForElement(30, "(//button[@class = 'oxd-icon-button'])[3]");
        driver.findElement(By.xpath("(//button[@class = 'oxd-icon-button'])[3]")).click();
    }

    public void ClickAddComment(){
        waitForElement(30, "//p[text() = 'Add Comment']");
        driver.findElement(By.xpath("//p[text() = 'Add Comment']")).click();
    }

    public void SetComment(String comment){
        waitForElement(30, "//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
        driver.findElement(By.xpath("//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).sendKeys(comment);
    }

    public void ClickSave(){
        waitForElement(30, "//button[text() = ' Save ']");
        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    public void CheckCommentAdded(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
