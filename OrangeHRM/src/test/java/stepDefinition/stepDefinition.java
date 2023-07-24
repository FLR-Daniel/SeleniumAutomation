package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefinition {
    WebDriver driver = null;
    String OrangeHRM = "https://opensource-demo.orangehrmlive.com/";
    String validUsername = "Daniel-FLR";
    String validPassword = "1LoveIceCream";
    String invalidPassword = "ILoveIceCream";
    String languagePackage = "Spanish - Español";
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
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.ClickContactDetails();
    }

    @And("I update the Street 1 field from contact details")
    public void iUpdateTheStreetFieldFromContactDetails() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.SetStreet1("Test123");
    }

    @And("I select Algeria as country")
    public void iSelectAlgeriaAsCountry() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.SetCountry("Algeria");
    }

    @And("I press the Save button")
    public void iPressTheSaveButton() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.ClickSave();
    }

    @Then("I should see the successfully updated confirmation message")
    public void iShouldSeeTheSuccessfullyUpdatedConfirmationMessage() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.CheckSuccess();
        driver.quit();
    }

    @And("I click on the profile picture")
    public void iClickOnTheProfilePicture() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);
        personalDetailsPage.ClickProfilePicture();
    }

    @And("I add a picture")
    public void iAddAPicture() {
        ProfilePicturePage profilePicturePage = new ProfilePicturePage(driver);
        profilePicturePage.AddPicture(picturePath);
    }

    @And("I click the Save button")
    public void iClickTheSaveButton() {
        ProfilePicturePage profilePicturePage = new ProfilePicturePage(driver);
        profilePicturePage.ClickSave();
    }

    @Then("I can see that my profile picture has been updated")
    public void iCanSeeThatMyProfilePictureHasBeenUpdated() {
        ProfilePicturePage profilePicturePage = new ProfilePicturePage(driver);
        profilePicturePage.CheckPictureUpload();
        driver.quit();
    }

    @And("I click the Add Attachments button")
    public void iClickTheAddAttachmentsButton() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.ClickAddAttachment();
    }

    @And("I select to upload a file")
    public void iSelectToUploadAFile() {
        ContactDetailsPage contactDetailsPage =  new ContactDetailsPage(driver);
        contactDetailsPage.AddAttachmentFile(filePath);
    }

    @And("I add a comment for this document uploaded in the comment field")
    public void iAddACommentForThisDocumentUploadedInTheCommentField() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.AddAttachmentComment("Test123");
    }

    @And("I press the Save button for this attachment added")
    public void iPressTheSaveButtonForThisAttachmentAdded() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.ClickAttachmentSave();
    }

    @Then("I am able to see my document added in the record found section by using css selector")
    public void iAmAbleToSeeMyDocumentAddedInTheRecordFoundSectionByUsingCssSelector() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.CheckAttachment("Test123");
        driver.quit();
    }

    @And("I tick the checkbox to select one record saved in the Records Found section")
    public void iTickTheCheckboxToSelectOneRecordSavedInTheRecordsFoundSection() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.SelectRecord();
    }

    @And("I press the Delete button to delete that record")
    public void iPressTheDeleteButtonToDeleteThatRecord() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.DeleteRecord();
    }

    @And("I press Yes to confirm this deletion")
    public void iPressYesToConfirmThisDeletion() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.ConfirmDeletion();
    }

    @Then("I should receive a confirmation message that the record has been deleted successfully")
    public void iShouldReceiveAConfirmationMessageThatTheRecordHasBeenDeletedSuccessfully() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.CheckDeletion();
        driver.quit();
    }

    @And("I click the Admin link from the menu")
    public void iClickTheAdminLinkFromTheMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.ClickAdmin();
    }

    @And("I click on the Configuration dropdown menu button")
    public void iClickOnTheConfigurationDropdownMenuButton() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickConfiguration();
    }

    @And("I click on the Language Packages option")
    public void iClickOnTheLanguagePackagesOption() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickLanguagePackages();
    }

    @And("I click on the Translate button for Spanish - Español language package")
    public void iClickOnTheTranslateButtonForSpanishEspañolLanguagePackage() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickOnTranslate(languagePackage);
    }

    @Then("I should be redirected to the languageCustomization page")
    public void iShouldBeRedirectedToTheLanguageCustomizationPage() {
        LanguageCustomizationPage languageCustomizationPage = new LanguageCustomizationPage(driver);
        languageCustomizationPage.CheckLanguageCusPage();
        driver.quit();
    }
}