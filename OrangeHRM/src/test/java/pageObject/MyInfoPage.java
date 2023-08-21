package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class MyInfoPage {

    public WebDriver driver;

    public MyInfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void clickContactDetails(){
        waitForElement(30, "//a[text() = 'Contact Details']");
        driver.findElement(By.xpath("//a[text() = 'Contact Details']")).click();
    }

    //===== VALIDATION STEPS =====//

}
