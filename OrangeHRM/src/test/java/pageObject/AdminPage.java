package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public void ClickConfiguration(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Configuration ']")));

        driver.findElement(By.xpath("//span[text() = 'Configuration ']")).click();
    }

    public void ClickLanguagePackages(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Language Packages']")));

        driver.findElement(By.xpath("//a[text() = 'Language Packages']")).click();
    }

    public void ClickOnTranslate(String language){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'oxd-table-card']")));

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'oxd-table-card']"));

        for(int i = 1; i <= elements.size(); i++){

            WebElement auxElement = driver.findElement(By.xpath("((//div[@class = 'oxd-table-card'])["+ i +"]/div/div/div)[1]"));

            if(auxElement.getText().contentEquals(language)){
                driver.findElement(By.xpath("(((//div[@class = 'oxd-table-card'])[" + i + "]/div/div/div)[2]/button)[1]")).click();
            }
        }
    }
}
