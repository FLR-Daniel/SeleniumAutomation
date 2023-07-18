package stepDefinition;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pageObject.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.peer.ChoicePeer;
import java.time.Duration;

public class stepDefinition {
    WebDriver driver = null;
    String OrangeHRM = "https://opensource-demo.orangehrmlive.com/";
    String validUsername = "Admin";
    String validPassword = "admin123";
    String invalidPassword = "ILoveIceCream";
    String picturePath  = "/Users/dflorea/projects/SeleniumAutomation/OrangeHRM/src/target/resources/1.jpeg";

    String filePath = "/Users/dflorea/projects/SeleniumAutomation/OrangeHRM/src/target/resources/Untitled.rtf";

    public stepDefinition() {
    }

    @Given("I access OrangeHRM page")
    public void navigate_to_site() {
        System.setProperty("webdriver.chrome.driver", "src/target/drivers/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();
        this.driver.navigate().to(OrangeHRM);
    }

    @When("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.SetUsername(validUsername);
        authenticatePage.SetPassword(invalidPassword);
    }

    @And("I press the Login button to log into my account")
    public void iPressTheLoginButtonToLogIntoMyAccount() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.ClickLogin();
    }

    @Then("I verify that an appropriate message is displayed for invalid credentials")
    public void iVerifyThatAnAppropriateMessageIsDisplayedForInvalidCredentials() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.CheckInvalidLogin();
        driver.quit();
    }

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.SetUsername(validUsername);
        authenticatePage.SetPassword(validPassword);
    }

    @Then("I verify that I am logged into my account by checking that the username is displayed")
    public void iVerifyThatIAmLoggedIntoMyAccountByCheckingThatTheUsernameIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.CheckLogin();
        driver.quit();
    }

    @And("I click the My Info option from the menu")
    public void iClickTheMyInfoOptionFromTheMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.ClickMyInfo();
    }

    @And("I click on the Contact Details link which will redirect me to the contactDetails page")
    public void iClickOnTheContactDetailsLinkWhichWillRedirectMeToTheContactDetailsPage() {
        MyInfo myInfo = new MyInfo(driver);
        myInfo.ClickContactDetails();
    }

    @And("I update the Street 1 field from contact details")
    public void iUpdateTheStreetFieldFromContactDetails() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.SetStreet1("Test123");
    }

    @And("I select Algeria as country")
    public void iSelectAlgeriaAsCountry() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.SetCountry("Algeria");
    }

    @And("I press the Save button")
    public void iPressTheSaveButton() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.ClickSave();
    }

    @Then("I should see the successfully updated confirmation message")
    public void iShouldSeeTheSuccessfullyUpdatedConfirmationMessage() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.CheckSuccess();
        driver.quit();
    }

    @And("I click on the profile picture")
    public void iClickOnTheProfilePicture() {
        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.ClickProfilePicture();
    }

    @And("I add a picture")
    public void iAddAPicture() {
        ProfilePicture profilePicture = new ProfilePicture(driver);
        profilePicture.AddPicture(picturePath);
    }

    @And("I click the Save button")
    public void iClickTheSaveButton() {
        ProfilePicture profilePicture = new ProfilePicture(driver);
        profilePicture.ClickSave();
    }

    @Then("I can see that my profile picture has been updated")
    public void iCanSeeThatMyProfilePictureHasBeenUpdated() {
        ProfilePicture profilePicture = new ProfilePicture(driver);
        profilePicture.CheckPictureUpload();
        driver.quit();
    }

    @And("I click the Add Attachments button")
    public void iClickTheAddAttachmentsButton() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.ClickAddAttachment();
    }

    @And("I select to upload a file")
    public void iSelectToUploadAFile() {
        ContactDetails contactDetails =  new ContactDetails(driver);
        contactDetails.AddAttachmentFile(filePath);
    }

    @And("I add a comment for this document uploaded in the comment field")
    public void iAddACommentForThisDocumentUploadedInTheCommentField() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.AddAttachmentComment("Test123");
    }

    @And("I press the Save button for this attachment added")
    public void iPressTheSaveButtonForThisAttachmentAdded() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.ClickAttachmentSave();
    }

    @Then("I am able to see my document added in the record found section by using css selector")
    public void iAmAbleToSeeMyDocumentAddedInTheRecordFoundSectionByUsingCssSelector() {
        ContactDetails contactDetails = new ContactDetails(driver);
        contactDetails.CheckAttachment("Test123");
        driver.quit();
    }
}