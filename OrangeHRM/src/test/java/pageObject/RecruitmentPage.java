package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RecruitmentPage {

    WebDriver driver;

    public RecruitmentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void clickVacancyTab(){
        waitForElement(30, "//a[text() = 'Vacancies']");
        driver.findElement(By.xpath("//a[text() = 'Vacancies']")).click();
    }

    public void setVacancy(String vacancy){
        waitForElement(30, "(//div[@class = 'oxd-select-text-input'])[2]");
        driver.findElement(By.xpath("(//div[@class = 'oxd-select-text-input'])[2]")).click();
        driver.findElement(By.xpath("//span[text() = '"+ vacancy +"']")).click();
    }

    public void clickSearch(){
        waitForElement(30, "//button[text() = ' Search ']");
        driver.findElement(By.xpath("//button[text() = ' Search ']")).click();
    }

    public void clickViewForStatus(String status){
        waitForElement(30, "//div[@class = 'oxd-table']");
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class = 'oxd-table-card']"));
        for(int i = 1; i <= elementList.size(); i++){
            if (driver.findElement(By.xpath("((//div[@class = 'oxd-table-card'])["+ i +"]/div/div)[6]/div")).getText().contentEquals(status)){
                driver.findElement(By.xpath("(((//div[@class = 'oxd-table-card'])["+ i +"]/div/div)[7]/div/button)[1]")).click();
                break;
            }
        }
    }

    public void clickScheduleInterview(){
        waitForElement(30, "//button[text() = ' Schedule Interview ']");
        driver.findElement(By.xpath("//button[text() = ' Schedule Interview ']")).click();
    }

    public void setInterviewTitle(String interviewTitle){
        waitForElement(30, "(//div[@class = 'oxd-input-group oxd-input-field-bottom-space'])[5]");
        driver.findElement(By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[6]")).sendKeys(interviewTitle);
    }

    public void addInterviewers(String interviewer1){
        //=======1st Interviewer=======
        waitForElement(30, "(//div[@class = 'oxd-input-group oxd-input-field-bottom-space'])[6]");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")).sendKeys(interviewer1);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();
    }
    public void addInterviewers(String interviewer1, String interviewer2){
        //=======1st Interviewer=======
        waitForElement(30, "(//div[@class = 'oxd-input-group oxd-input-field-bottom-space'])[6]");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")).sendKeys(interviewer1);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();

        //=======2nd Interviewer=======
        waitForElement(30, "//button[@class = 'oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']");
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']")).click();

        waitForElement(30, "(//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[2]");
        driver.findElement(By.xpath("(//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[2]")).sendKeys(interviewer2);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();
    }

    public void addInterviewers(String interviewer1, String interviewer2, String interviewer3){
        //=======1st Interviewer=======
        waitForElement(30, "(//div[@class = 'oxd-input-group oxd-input-field-bottom-space'])[6]");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")).sendKeys(interviewer1);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();

        //=======2nd Interviewer=======
        waitForElement(30, "//button[@class = 'oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']");
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']")).click();

        waitForElement(30, "(//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[2]");
        driver.findElement(By.xpath("(//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[2]")).sendKeys(interviewer2);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();

        //=======3rd Interviewer=======
        waitForElement(30, "//button[@class = 'oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']");
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--text orangehrm-input-field-bottom-space']")).click();

        waitForElement(30, "(//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[3]");
        driver.findElement(By.xpath("(//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[3]")).sendKeys(interviewer3);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();
    }

    /**
     *
     * @param date Date Format: 'yyyy-mm-dd'
     */
    public void setInterviewDate(String date){
        waitForElement(30, "//input[@placeholder = 'yyyy-mm-dd']");
        driver.findElement(By.xpath("//input[@placeholder = 'yyyy-mm-dd']")).sendKeys(date);
    }

    /**
     *
     * @param time Time Format: 'hh:mm AM/PM'
     */
    public void setInterviewTime(String time){
        waitForElement(30, "//input[@placeholder = 'hh:mm']");
        driver.findElement(By.xpath("//input[@placeholder = 'hh:mm']")).sendKeys(time);
    }

    public void clickSave(){
        waitForElement(30, "//button[text() = ' Save ']");
        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    //===== VALIDATION STEPS =====//

    public void checkRecordsByVacancy(String vacancy){
        waitForElement(30, "//div[@class = 'oxd-table-cell oxd-padding-cell']/div[text() = '"+ vacancy +"']");
        driver.findElement(By.xpath("//div[@class = 'oxd-table-cell oxd-padding-cell']/div[text() = '"+ vacancy +"']")).isDisplayed();
    }

    public void checkScheduleInterview(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }
}
