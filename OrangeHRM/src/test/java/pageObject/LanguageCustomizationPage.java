package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageCustomizationPage {

    WebDriver driver;

    public LanguageCustomizationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void CheckLanguageCusPage(){
        waitForElement(30, "//h5[text() = 'Translate Language Package']");
        driver.findElement(By.xpath("//h5[text() = 'Translate Language Package']")).isDisplayed();
    }
}
