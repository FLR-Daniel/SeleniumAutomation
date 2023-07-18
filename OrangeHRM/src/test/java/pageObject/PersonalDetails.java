package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDetails {

    WebDriver driver;

    public PersonalDetails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickProfilePicture(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class, 'employee-image')]")));

        driver. findElement(By.xpath("//img[contains(@class, 'employee-image')]")).click();
    }
}
