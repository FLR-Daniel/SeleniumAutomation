package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;

import java.time.Duration;
public class MyInfo {

    public WebDriver driver;

    public MyInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickContactDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Contact Details']")));

        driver.findElement(By.xpath("//a[text() = 'Contact Details']")).click();
    }

}
