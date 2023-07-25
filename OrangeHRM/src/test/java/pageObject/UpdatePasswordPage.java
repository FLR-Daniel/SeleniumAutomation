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

    public void SetCurrentPassword(String currentPassword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type = 'password'])[1]")));

        driver.findElement(By.xpath("(//input[@type = 'password'])[1]")).sendKeys(currentPassword);
    }

    public void SetNewPassword(String newPassword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type = 'password'])[2]")));

        driver.findElement(By.xpath("(//input[@type = 'password'])[2]")).sendKeys(newPassword);
    }

    public void SetConfirmPassword(String confirmPassword){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type = 'password'])[3]")));

        driver.findElement(By.xpath("(//input[@type = 'password'])[3]")).sendKeys(confirmPassword);
    }

    public void ClickSave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = ' Save ']")));

        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    public void CheckPasswordChange(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")));

        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
