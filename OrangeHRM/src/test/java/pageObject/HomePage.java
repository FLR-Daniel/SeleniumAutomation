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

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }
    public void clickMyInfo() {
        waitForElement(30, "//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')]");
        driver.findElement(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')][text() = 'My Info']")).click();
    }

    public void clickAdmin() {
        waitForElement(30, "//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')]");
        driver.findElement(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')][text() = 'Admin']")).click();
    }

    public void clickChangePassword() {
        waitForElement(30, "//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
        driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
        waitForElement(30, "//a[text() = 'Change Password']");
        driver.findElement(By.xpath("//a[text() = 'Change Password']")).click();
    }

    public void clickMaintenance() {
        waitForElement(30, "//span[text() = 'Maintenance']");
        driver.findElement(By.xpath("//span[text() = 'Maintenance']")).click();
    }

    public void clickPIM() {
        waitForElement(30, "//span[text() = 'PIM']");
        driver.findElement(By.xpath("//span[text() = 'PIM']")).click();
    }

    public void clickLeave(){
        waitForElement(30, "//span[text() = 'Leave']");
        driver.findElement(By.xpath("//span[text() = 'Leave']")).click();
    }

    public void clickRecruitment(){
        waitForElement(30, "//span[text() = 'Recruitment']");
        driver.findElement(By.xpath("//span[text() = 'Recruitment']")).click();
    }

    //===== VALIDATION STEPS =====//

    public void checkLogin() {
        waitForElement(30, "//p[contains(@class, 'oxd-userdropdown-name')]");

        driver.findElement(By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]")).isDisplayed();
    }
}