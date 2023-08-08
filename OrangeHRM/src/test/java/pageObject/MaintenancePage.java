package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MaintenancePage {

    WebDriver driver;

    public MaintenancePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void setValidationCredentials(String password){
        waitForElement(30, "//input[@name= 'password']");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys(password);
    }

    public void clickConfirm(){
        waitForElement(30, "//button[text() = ' Confirm ']");
        driver.findElement(By.xpath("//button[text() = ' Confirm ']")).click();
    }

    public void clickAccess(){
        waitForElement(30, "//a[text() = 'Access Records']");
        driver.findElement(By.ByXPath.xpath("//a[text() = 'Access Records']")).click();
    }

    public void setEmployeeName(String name){
        waitForElement(30, "//input[@placeholder = 'Type for hints...']");
        driver.findElement(By.xpath("//input[@placeholder = 'Type for hints...']")).sendKeys(name);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();
    }

    public void clickSearch(){
        waitForElement(30, "//button[text() = ' Search ']");
        driver.findElement(By.xpath("//button[text() = ' Search ']")).click();
    }

    public void checkVisibilityID(){
        waitForElement(30, "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div.orangehrm-background-container > div > form > div.orangehrm-selected-employee > div.orangehrm-selected-employee-content > div:nth-child(2) > div > div > div > div:nth-child(2) > input");
        driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div.orangehrm-background-container > div > form > div.orangehrm-selected-employee > div.orangehrm-selected-employee-content > div:nth-child(2) > div > div > div > div:nth-child(2) > input")).isDisplayed();
    }
}
