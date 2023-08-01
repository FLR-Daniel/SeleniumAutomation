package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void ClickConfiguration(){
        waitForElement(30, "//span[text() = 'Configuration ']");
        driver.findElement(By.xpath("//span[text() = 'Configuration ']")).click();
    }

    public void ClickLanguagePackages(){
        waitForElement(30, "//a[text() = 'Language Packages']");
        driver.findElement(By.xpath("//a[text() = 'Language Packages']")).click();
    }

    public void ClickOnTranslate(String language){
        waitForElement(30, "//div[@class = 'oxd-table-card']");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'oxd-table-card']"));

        for(int i = 1; i <= elements.size(); i++){

            WebElement auxElement = driver.findElement(By.xpath("((//div[@class = 'oxd-table-card'])["+ i +"]/div/div/div)[1]"));

            if(auxElement.getText().contentEquals(language)){
                driver.findElement(By.xpath("(((//div[@class = 'oxd-table-card'])[" + i + "]/div/div/div)[2]/button)[1]")).click();
            }
        }
    }

    public void ClickOnAddLanguage(){
        waitForElement(30, "//button[text() = ' Add ']");
        driver.findElement(By.xpath("//button[text() = ' Add ']")).click();
    }

    public void SelectAddLanguage(String language){
        waitForElement(30, "//div[@class = 'oxd-select-text oxd-select-text--active']");
        driver.findElement(By.xpath("//div[@class = 'oxd-select-text--after']")).click();
        driver.findElement(By.xpath("//span[text() = '"+ language +"']")).click();
    }

    public void ClickSaveOnAddLanguage(){
        waitForElement(30, "//button[text() = ' Save ']");
        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    public void CheckLanguageAddition(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }

    public void ClickJobTitle() {
        waitForElement(30, "//span[text() = 'Job ']");
        driver.findElement(By.xpath("//span[text() = 'Job ']")).click();
        waitForElement(30, "//a[text() = 'Job Titles']");
        driver.findElement(By.xpath("//a[text() = 'Job Titles']")).click();
    }
}
