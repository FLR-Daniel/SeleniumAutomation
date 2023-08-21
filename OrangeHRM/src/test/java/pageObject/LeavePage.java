package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage {

    WebDriver driver;

    public LeavePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //===== ACTION STEPS =====//

    public void waitForElement(long durationSeconds, String selector){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    public void clickDotsUser(){
        waitForElement(30, "(//button[@class = 'oxd-icon-button'])[3]");
        driver.findElement(By.xpath("(//button[@class = 'oxd-icon-button'])[3]")).click();
    }

    public void clickAddComment(){
        waitForElement(30, "//p[text() = 'Add Comment']");
        driver.findElement(By.xpath("//p[text() = 'Add Comment']")).click();
    }

    public void setComment(String comment){
        waitForElement(30, "//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
        driver.findElement(By.xpath("//textarea[@class = 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).sendKeys(comment);
    }

    public void clickSave(){
        waitForElement(30, "//button[text() = ' Save ']");
        driver.findElement(By.xpath("//button[text() = ' Save ']")).click();
    }

    /**
     * Sets the period dates for leave filter.
     *
     *@param fromDate Date Format: yyyy-mm-dd.
     *@param toDate Date Format: yyyy-mm-dd.
     */
    public void setDatePeriod(String fromDate, String toDate){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitForElement(30, "(//input[@placeholder = 'yyyy-mm-dd'])[1]");
        WebElement element1  = driver.findElement(By.xpath("(//input[@placeholder = 'yyyy-mm-dd'])[1]"));
        js.executeScript("arguments[0].value = '" + fromDate + "';", element1);

        waitForElement(30, "(//input[@placeholder = 'yyyy-mm-dd'])[2]");
        WebElement element2  = driver.findElement(By.xpath("(//input[@placeholder = 'yyyy-mm-dd'])[2]"));
        js.executeScript("arguments[0].value = '" + toDate + "';", element2);
    }

    public void selectPendingApprove(){
        try{
            waitForElement(30, "//span[text() = 'Pending Approval ']");
            driver.findElement(By.xpath("//span[text() = 'Pending Approval ']")).isDisplayed();
        }
        catch (Exception e){
            waitForElement(30, "//span[@class = 'oxd-chip oxd-chip--default oxd-multiselect-chips-selected']/i");
            driver.findElement(By.xpath("//span[@class = 'oxd-chip oxd-chip--default oxd-multiselect-chips-selected']/i")).click();
            driver.findElement(By.xpath("//div[text() = 'Select']")).click();
            driver.findElement(By.xpath("//span[text() = 'Pending Approval ']")).click();
        }
    }

    public void selectLeaveType(String leaveType){
        waitForElement(30, "(//div[text() = '-- Select --'])[1]");
        driver.findElement(By.xpath("(//div[text() = '-- Select --'])[1]")).click();

        waitForElement(30, "//span[text() = '"+ leaveType +"']");
        driver.findElement(By.xpath("//span[text() = '"+ leaveType +"']")).click();
    }

    public void clickSearch(){
        waitForElement(30, "//button[text() = ' Search ']");
        driver.findElement(By.xpath("//button[text() = ' Search ']")).click();
    }

    public void selectRejectedStatus(){
        waitForElement(30, "(//div[@class = 'oxd-select-text-input'])[1]");
        driver.findElement(By.xpath("(//div[@class = 'oxd-select-text-input'])[1]")).click();
        driver.findElement(By.xpath("//span[text() = 'Rejected']")).click();
    }

    public void setEmployeeName(String fullName){
        waitForElement(30, "//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")).sendKeys(fullName);

        try{Thread.sleep(3000);}
        catch (Exception e){
            System.out.println(e);
        }
        waitForElement(30, "//div[@class = 'oxd-autocomplete-option']");
        driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option']")).click();
    }

    public void clickReset(){
        waitForElement(30, "//button[text() = ' Reset ']");
        driver.findElement(By.xpath("//button[text() = ' Reset ']")).click();
    }

    //===== VALIDATION STEPS =====//

    public void checkCommentAdded(){
        waitForElement(30, "//div[contains(@class, 'oxd-toast oxd-toast--success')]");
        driver.findElement(By.xpath("//div[contains(@class, 'oxd-toast oxd-toast--success')]")).isDisplayed();
    }

    public void checkLeaveResults() {
        try {
            waitForElement(1, "//div[@class = 'oxd-table-card']");
            driver.findElement(By.xpath("//div[@class = 'oxd-table-card']")).isDisplayed();
        } catch (Exception e) {
            waitForElement(5, "//p[text() = 'No Records Found']");
            driver.findElement(By.xpath("//p[text() = 'No Records Found']")).isDisplayed();
            System.out.println("!!! No Leave Records Found With Selected Filters!!!");
        }
    }

    public void checkRejected(){
        waitForElement(30, "//span[text()= 'Rejected ']");
        driver.findElement(By.xpath("//span[text()= 'Rejected ']")).isDisplayed();
    }


}
