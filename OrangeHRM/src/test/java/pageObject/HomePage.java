package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CheckLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]")));
        driver.findElement(By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]")).isDisplayed();
    }

    public void ClickMyInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')]")));

        driver.findElement(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')][text() = 'My Info']")).click();
    }

    public void ClickAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')]")));

        driver.findElement(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')][text() = 'Admin']")).click();
    }

    public void ClickChangePassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")));

        driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Change Password']")));

        driver.findElement(By.xpath("//a[text() = 'Change Password']")).click();
    }

    public void ClickMaintenance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Maintenance']")));

        driver.findElement(By.xpath("//span[text() = 'Maintenance']")).click();
    }

    public void ClickPIM() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'PIM']")));

        driver.findElement(By.xpath("//span[text() = 'PIM']")).click();
    }
}