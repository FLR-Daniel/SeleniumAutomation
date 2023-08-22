package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage implements Global{

    WebDriver driver;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void clickConfiguration(){
        waitForElement(30, configurationButton);
        driver.findElement(By.xpath(configurationButton)).click();
    }

    public void clickLanguagePackages(){
        waitForElement(30, languagePackageButton);
        driver.findElement(By.xpath(languagePackageButton)).click();
    }

    public void clickOnTranslate(String language){
        waitForElement(30, "//div[@class = 'oxd-table-card']");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'oxd-table-card']"));

        for(int i = 1; i <= elements.size(); i++){

            WebElement auxElement = driver.findElement(By.xpath("((//div[@class = 'oxd-table-card'])["+ i +"]/div/div/div)[1]"));

            if(auxElement.getText().contentEquals(language)){
                driver.findElement(By.xpath("(((//div[@class = 'oxd-table-card'])[" + i + "]/div/div/div)[2]/button)[1]")).click();
            }
        }
    }

    public void clickOnAddLanguage(){
        waitForElement(30, addButton);
        driver.findElement(By.xpath(addButton)).click();
    }

    public void selectAddLanguage(String language){
        waitForElement(30, "//div[@class = 'oxd-select-text oxd-select-text--active']");
        driver.findElement(By.xpath("//div[@class = 'oxd-select-text--after']")).click();
        driver.findElement(By.xpath("//span[text() = '"+ language +"']")).click();
    }

    public void clickSaveOnAddLanguage(){
        waitForElement(30, saveButton);
        driver.findElement(By.xpath(saveButton)).click();
    }

    public void clickJobTitle() {
        waitForElement(30, "//span[text() = 'Job ']");
        driver.findElement(By.xpath("//span[text() = 'Job ']")).click();
        waitForElement(30, "//a[text() = 'Job Titles']");
        driver.findElement(By.xpath("//a[text() = 'Job Titles']")).click();
    }

    //===== VALIDATION STEPS =====//

    public void checkLanguageAddition(){
        waitForElement(30, successToast);
        driver.findElement(By.xpath(successToast)).isDisplayed();
    }
}
