package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePicturePage {

    WebDriver driver;

    public ProfilePicturePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void AddPicture(String filePath){
        waitForElement(30, "//button[contains(@class, 'oxd-icon-button oxd-icon-button--solid-main employee-image-action')]");
        WebElement fileElement = driver.findElement(By.xpath("//input[contains(@type, 'file')]"));
        fileElement.sendKeys(filePath);
    }

    public void ClickSave(){
        waitForElement(30, "//button[contains(@type, 'submit')]");
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();
    }

    public void CheckPictureUpload(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
