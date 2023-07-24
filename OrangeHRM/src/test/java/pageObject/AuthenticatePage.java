package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthenticatePage {
    public WebDriver driver;

    public AuthenticatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SetUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name, 'username')]")));

        driver.findElement(By.xpath("//input[contains(@name, 'username')]")).sendKeys(username);
    }
    public void SetPassword(String password){
        driver.findElement(By.xpath("//input[contains(@name, 'password')]")).sendKeys(password);
    }

    public void ClickLogin(){
        driver.findElement(By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]")).click();
    }

    public void ClickForgot(){
        driver.findElement(By.xpath("//div[contains(@class, 'orangehrm-login-forgot')]/p")).click();
    }

    public void CheckInvalidLogin(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-alert oxd-alert--error')]")));
        driver.findElement(By.xpath("//p[text() = 'Invalid credentials']")).isDisplayed();
    }
}
