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
    String newPassword = "Test123";
    String invalidPassword = "ILoveIceCream";
    String languagePackage = "Spanish - Español";
    String languageToAdd = "Colognian (Germany)";
    String picturePath  = "/Users/dflorea/projects/SeleniumAutomation/OrangeHRM/src/target/resources/1.jpeg";

    String filePath = "/Users/dflorea/projects/SeleniumAutomation/OrangeHRM/src/target/resources/Untitled.rtf";

    public stepDefinition() {
    }

    //Login with invalid credentials

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

    //Login with valid credentials

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

    //As a user I am able to update my street and country details

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

    //As a user I can change my profile picture

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

    //As a user I am able to add an attachment into my Contact Details

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

    //As a user I am able to delete a record from my Contact Details

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

    //As a user I am able to access the Language Packages

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
    public void iClickOnTheTranslateButtonForSpanishEspanolLanguagePackage() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickOnTranslate(languagePackage);
    }

    @Then("I should be redirected to the languageCustomization page")
    public void iShouldBeRedirectedToTheLanguageCustomizationPage() {
        LanguageCustomizationPage languageCustomizationPage = new LanguageCustomizationPage(driver);
        languageCustomizationPage.CheckLanguageCusPage();
        driver.quit();
    }

    //As a user I am able to add a new language Package

    @And("I click the Add button to add a new language to the packages")
    public void iClickTheAddButtonToAddANewLanguageToThePackages() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickOnAddLanguage();
    }

    @And("I select the language Colognian\\(Germany) from that list")
    public void iSelectTheLanguageColognianGermanyFromThatList() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.SelectAddLanguage(languageToAdd);
    }

    @And("I press the Save to add this new language to my packages")
    public void iPressTheSaveToAddThisNewLanguageToMyPackages() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickSaveOnAddLanguage();
    }

    @Then("I should be able to see the confirmation message that the language was successfully saved")
    public void iShouldBeAbleToSeeTheConfirmationMessageThatTheLanguageWasSuccessfullySaved() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.CheckLanguageAddition();
        driver.quit();
    }

    //Change Password for a user

    @And("I select the Change Password option from drop-down user profile menu")
    public void iSelectTheChangePasswordOptionFromDropDownUserProfileMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.ClickChangePassword();
    }

    @And("I enter the current password in the Current Password field")
    public void iEnterTheCurrentPasswordInTheCurrentPasswordField() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.SetCurrentPassword(validPassword);
    }

    @And("I enter in the Password field a new password")
    public void iEnterInThePasswordFieldANewPassword() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.SetNewPassword(newPassword);
    }

    @And("I confirm the new password")
    public void iConfirmTheNewPassword() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.SetConfirmPassword(newPassword);
    }

    @And("I press the Save button to update the password")
    public void iPressTheSaveButtonToUpdateThePassword() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.ClickSave();
    }

    @Then("I should be able to see the confirmation message")
    public void iShouldBeAbleToSeeTheConfirmationMessage() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.CheckPasswordChange();
        driver.quit();
    }

    //As a user I want to add a new job

    @And("I select the Job Titles option from the Job menu dropdown")
    public void iSelectTheJobTitlesOptionFromTheJobMenuDropdown() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.ClickJobTitle();
    }

    @And("I click the Add button to add a new job")
    public void iClickTheAddButtonToAddANewJob() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.ClickAdd();
    }

    @And("I add a name for the job in the Job Title field")
    public void iAddANameForTheJobInTheJobTitleField() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.SetJobTitle("Test123");
    }

    @And("I add a job description")
    public void iAddAJobDescription() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.SetJobDescription("Test123");
    }

    @And("I add a Job Specification file")
    public void iAddAJobSpecificationFile() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.SetJobFile(filePath);
    }

    @And("I click the Save button to add the new job")
    public void iClickTheSaveButtonToAddTheNewJob() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.ClickSave();
    }

    @Then("I should see the confirmation message that the job was successfully added")
    public void iShouldSeeTheConfirmationMessageThatTheJobWasSuccessfullyAdded() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.CheckSuccess();
        driver.quit();
    }

    //As a user I can access an employee's records

    @And("I click on the Maintenance option from the menu which will redirect me to the purgeEmployee page")
    public void iClickOnTheMaintenanceOptionFromTheMenuWhichWillRedirectMeToThePurgeEmployeePage() {
        HomePage homePage = new HomePage(driver);
        homePage.ClickMaintenance();
    }

    @And("I enter my password to validate my administrator credentials")
    public void iEnterMyPasswordToValidateMyAdministratorCredentials() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.SetValidationCredentials(validPassword);
    }

    @And("I click the Confirm button")
    public void iClickTheConfirmButton() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.ClickConfirm();
    }

    @And("I click on the Access Records option")
    public void iClickOnTheAccessRecordsOption() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.ClickAccess();
    }

    @And("I enter Anthony Anadebe in the Employee Name field")
    public void iEnterAnthonyAnadebeInTheEmployeeNameField() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.SetEmployeeName("Daniel Flore");
    }

    @And("click on the Search button")
    public void clickOnTheSearchButton() {
        MaintenancePage maintenancePage =  new MaintenancePage(driver);
        maintenancePage.ClickSearch();
    }

    @Then("I can see that the employee ID is displayed in the Selected Employee section by using css selector")
    public void iCanSeeThatTheEmployeeIDIsDisplayedInTheSelectedEmployeeSectionByUsingCssSelector() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.CheckVisibilityID();
        driver.quit();
    }
}