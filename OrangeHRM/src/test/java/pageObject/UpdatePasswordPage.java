package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdatePasswordPage {

    WebDriver driver;

    public UpdatePasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void SetCurrentPassword(String currentPassword){
        waitForElement(30, "(//input[@type = 'password'])[1]");
        driver.findElement(By.xpath("(//input[@type = 'password'])[1]")).sendKeys(currentPassword);
    }

    public void SetNewPassword(String newPassword){
        waitForElement(30, "(//input[@type = 'password'])[2]");
        driver.findElement(By.xpath("(//input[@type = 'password'])[2]")).sendKeys(newPassword);
    }

    public void SetConfirmPassword(String confirmPassword){
        waitForElement(30, "(//input[@type = 'password'])[3]");
        driver.findElement(By.xpath("(//input[@type = 'password'])[3]")).sendKeys(confirmPassword);
    }

    public void ClickSave(){
        waitForElement(30, "//button[text() = ' Save ']");
        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    public void CheckPasswordChange(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
