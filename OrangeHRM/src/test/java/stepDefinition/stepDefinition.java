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
        authenticatePage.setUsername(validUsername);
        authenticatePage.setPassword(invalidPassword);
    }

    @And("I press the Login button to log into my account")
    public void iPressTheLoginButtonToLogIntoMyAccount() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.clickLogin();
    }

    @Then("I verify that an appropriate message is displayed for invalid credentials")
    public void iVerifyThatAnAppropriateMessageIsDisplayedForInvalidCredentials() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.checkInvalidLogin();
        driver.quit();
    }

    //Login with valid credentials

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        AuthenticatePage authenticatePage = new AuthenticatePage(driver);
        authenticatePage.setUsername(validUsername);
        authenticatePage.setPassword(validPassword);
    }

    @Then("I verify that I am logged into my account by checking that the username is displayed")
    public void iVerifyThatIAmLoggedIntoMyAccountByCheckingThatTheUsernameIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.checkLogin();
        driver.quit();
    }

    //As a user I am able to update my street and country details

    @And("I click the My Info option from the menu")
    public void iClickTheMyInfoOptionFromTheMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyInfo();
    }

    @And("I click on the Contact Details link which will redirect me to the contactDetails page")
    public void iClickOnTheContactDetailsLinkWhichWillRedirectMeToTheContactDetailsPage() {
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.clickContactDetails();
    }

    @And("I update the Street 1 field from contact details")
    public void iUpdateTheStreetFieldFromContactDetails() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.setStreet1("Test123");
    }

    @And("I select Algeria as country")
    public void iSelectAlgeriaAsCountry() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.setCountry("Algeria");
    }

    @And("I press the Save button")
    public void iPressTheSaveButton() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.clickSave();
    }

    @Then("I should see the successfully updated confirmation message")
    public void iShouldSeeTheSuccessfullyUpdatedConfirmationMessage() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.checkSuccess();
        driver.quit();
    }

    //As a user I can change my profile picture

    @And("I click on the profile picture")
    public void iClickOnTheProfilePicture() {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage(driver);
        personalDetailsPage.clickProfilePicture();
    }

    @And("I add a picture")
    public void iAddAPicture() {
        ProfilePicturePage profilePicturePage = new ProfilePicturePage(driver);
        profilePicturePage.addPicture(picturePath);
    }

    @And("I click the Save button")
    public void iClickTheSaveButton() {
        ProfilePicturePage profilePicturePage = new ProfilePicturePage(driver);
        profilePicturePage.clickSave();
    }

    @Then("I can see that my profile picture has been updated")
    public void iCanSeeThatMyProfilePictureHasBeenUpdated() {
        ProfilePicturePage profilePicturePage = new ProfilePicturePage(driver);
        profilePicturePage.checkPictureUpload();
        driver.quit();
    }

    //As a user I am able to add an attachment into my Contact Details

    @And("I click the Add Attachments button")
    public void iClickTheAddAttachmentsButton() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.clickAddAttachment();
    }

    @And("I select to upload a file")
    public void iSelectToUploadAFile() {
        ContactDetailsPage contactDetailsPage =  new ContactDetailsPage(driver);
        contactDetailsPage.addAttachmentFile(filePath);
    }

    @And("I add a comment for this document uploaded in the comment field")
    public void iAddACommentForThisDocumentUploadedInTheCommentField() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.addAttachmentComment("Test123");
    }

    @And("I press the Save button for this attachment added")
    public void iPressTheSaveButtonForThisAttachmentAdded() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.clickAttachmentSave();
    }

    @Then("I am able to see my document added in the record found section by using css selector")
    public void iAmAbleToSeeMyDocumentAddedInTheRecordFoundSectionByUsingCssSelector() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.checkAttachment("Test123");
        driver.quit();
    }

    //As a user I am able to delete a record from my Contact Details

    @And("I tick the checkbox to select one record saved in the Records Found section")
    public void iTickTheCheckboxToSelectOneRecordSavedInTheRecordsFoundSection() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.selectRecord();
    }

    @And("I press the Delete button to delete that record")
    public void iPressTheDeleteButtonToDeleteThatRecord() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.deleteRecord();
    }

    @And("I press Yes to confirm this deletion")
    public void iPressYesToConfirmThisDeletion() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.confirmDeletion();
    }

    @Then("I should receive a confirmation message that the record has been deleted successfully")
    public void iShouldReceiveAConfirmationMessageThatTheRecordHasBeenDeletedSuccessfully() {
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        contactDetailsPage.checkDeletion();
        driver.quit();
    }

    //As a user I am able to access the Language Packages

    @And("I click the Admin link from the menu")
    public void iClickTheAdminLinkFromTheMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAdmin();
    }

    @And("I click on the Configuration dropdown menu button")
    public void iClickOnTheConfigurationDropdownMenuButton() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickConfiguration();
    }

    @And("I click on the Language Packages option")
    public void iClickOnTheLanguagePackagesOption() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickLanguagePackages();
    }

    @And("I click on the Translate button for Spanish - Español language package")
    public void iClickOnTheTranslateButtonForSpanishEspanolLanguagePackage() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickOnTranslate(languagePackage);
    }

    @Then("I should be redirected to the languageCustomization page")
    public void iShouldBeRedirectedToTheLanguageCustomizationPage() {
        LanguageCustomizationPage languageCustomizationPage = new LanguageCustomizationPage(driver);
        languageCustomizationPage.checkLanguageCusPage();
        driver.quit();
    }

    //As a user I am able to add a new language Package

    @And("I click the Add button to add a new language to the packages")
    public void iClickTheAddButtonToAddANewLanguageToThePackages() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickOnAddLanguage();
    }

    @And("I select the language Colognian\\(Germany) from that list")
    public void iSelectTheLanguageColognianGermanyFromThatList() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.selectAddLanguage(languageToAdd);
    }

    @And("I press the Save to add this new language to my packages")
    public void iPressTheSaveToAddThisNewLanguageToMyPackages() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickSaveOnAddLanguage();
    }

    @Then("I should be able to see the confirmation message that the language was successfully saved")
    public void iShouldBeAbleToSeeTheConfirmationMessageThatTheLanguageWasSuccessfullySaved() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.checkLanguageAddition();
        driver.quit();
    }

    //Change Password for a user

    @And("I select the Change Password option from drop-down user profile menu")
    public void iSelectTheChangePasswordOptionFromDropDownUserProfileMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickChangePassword();
    }

    @And("I enter the current password in the Current Password field")
    public void iEnterTheCurrentPasswordInTheCurrentPasswordField() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.setCurrentPassword(validPassword);
    }

    @And("I enter in the Password field a new password")
    public void iEnterInThePasswordFieldANewPassword() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.setNewPassword(newPassword);
    }

    @And("I confirm the new password")
    public void iConfirmTheNewPassword() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.setConfirmPassword(newPassword);
    }

    @And("I press the Save button to update the password")
    public void iPressTheSaveButtonToUpdateThePassword() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.clickSave();
    }

    @Then("I should be able to see the confirmation message")
    public void iShouldBeAbleToSeeTheConfirmationMessage() {
        UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
        updatePasswordPage.checkPasswordChange();
        driver.quit();
    }

    //As a user I want to add a new job

    @And("I select the Job Titles option from the Job menu dropdown")
    public void iSelectTheJobTitlesOptionFromTheJobMenuDropdown() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickJobTitle();
    }

    @And("I click the Add button to add a new job")
    public void iClickTheAddButtonToAddANewJob() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.clickAdd();
    }

    @And("I add a name for the job in the Job Title field")
    public void iAddANameForTheJobInTheJobTitleField() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.setJobTitle("Test123");
    }

    @And("I add a job description")
    public void iAddAJobDescription() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.setjobdescription("Test123");
    }

    @And("I add a Job Specification file")
    public void iAddAJobSpecificationFile() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.setJobFile(filePath);
    }

    @And("I click the Save button to add the new job")
    public void iClickTheSaveButtonToAddTheNewJob() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.clickSave();
    }

    @Then("I should see the confirmation message that the job was successfully added")
    public void iShouldSeeTheConfirmationMessageThatTheJobWasSuccessfullyAdded() {
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        jobTitlePage.checkSuccess();
        driver.quit();
    }

    //As a user I can access an employee's records

    @And("I click on the Maintenance option from the menu which will redirect me to the purgeEmployee page")
    public void iClickOnTheMaintenanceOptionFromTheMenuWhichWillRedirectMeToThePurgeEmployeePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMaintenance();
    }

    @And("I enter my password to validate my administrator credentials")
    public void iEnterMyPasswordToValidateMyAdministratorCredentials() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.setValidationCredentials(validPassword);
    }

    @And("I click the Confirm button")
    public void iClickTheConfirmButton() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.clickConfirm();
    }

    @And("I click on the Access Records option")
    public void iClickOnTheAccessRecordsOption() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.clickAccess();
    }

    @And("I enter Anthony Anadebe in the Employee Name field")
    public void iEnterAnthonyAnadebeInTheEmployeeNameField() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.setEmployeeName("Daniel Flore");
    }

    @And("click on the Search button")
    public void clickOnTheSearchButton() {
        MaintenancePage maintenancePage =  new MaintenancePage(driver);
        maintenancePage.clickSearch();
    }

    @Then("I can see that the employee ID is displayed in the Selected Employee section by using css selector")
    public void iCanSeeThatTheEmployeeIDIsDisplayedInTheSelectedEmployeeSectionByUsingCssSelector() {
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.checkVisibilityID();
        driver.quit();
    }

    // As a user I am able to add a new employee

    @And("I click on the PIM option from the menu")
    public void iClickOnThePIMOptionFromTheMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPIM();
    }

    @And("I choose the Add Employee option")
    public void iChooseTheAddEmployeeOption() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickAdd();
    }

    @And("I add a profile picture for that employee")
    public void iAddAProfilePictureForThatEmployee() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.addProfilePicture(picturePath);
    }

    @And("I enter the employee's full name in the Employee Full Name section")
    public void iEnterTheEmployeeSFullNameInTheEmployeeFullNameSection() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.setFirstName("Daniel");
        pimPage.setMiddleName("Test123");
        pimPage.setLastName("Florea");
    }

    @And("I enter an employee id in the Employee Id field")
    public void iEnterAnEmployeeIdInTheEmployeeIdField() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.setId("9999");
    }

    @And("I click the Create Login Details button to make the option available")
    public void iClickTheCreateLoginDetailsButtonToMakeTheOptionAvailable() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.thickCreateLoginDetails();
    }

    @And("I add a username and password")
    public void iAddAUsernameAndPassword() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.setUsername("Test123");
        pimPage.setPassword("Test123");
        pimPage.setConfirmPassword("Test123");
        pimPage.setId("9999");
    }

    @Then("I should see a confirmation message that the employee was successfully saved")
    public void iShouldSeeAConfirmationMessageThatTheEmployeeWasSuccessfullySaved() {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.checkCreation();
        driver.quit();
    }

    //As a user I can add a comment for a leave request

    @And("I click the Leave link from the menu")
    public void iClickTheLeaveLinkFromTheMenu() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLeave();
    }

    @And("I click on the button with three dots which is located in the left corner for an employee record")
    public void iClickOnTheButtonWithThreeDotsWhichIsLocatedInTheLeftCornerForAnEmployeeRecord() {
        LeavePage leavePage =  new LeavePage(driver);
        leavePage.clickDotsUser();
    }

    @And("I select to Add Comment from that list")
    public void iSelectToAddCommentFromThatList() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.clickAddComment();
    }

    @And("I enter a comment in the Leave Request Comments section")
    public void iEnterACommentInTheLeaveRequestCommentsSection() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.setComment("Test123");
    }

    @And("I save the comment")
    public void iSaveTheComment() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.clickSave();
    }

    @Then("I should be able to see the confirmation message that the comment was added successfully")
    public void iShouldBeAbleToSeeTheConfirmationMessageThatTheCommentWasAddedSuccessfully() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.sheckCommentAdded();
        driver.quit();
    }

    //As a user I want to see all the vacation leave records for a certain period

    @And("I select a specific period for which I want to see the records")
    public void iSelectASpecificPeriodForWhichIWantToSeeTheRecords() {
        LeavePage leavePage =  new LeavePage(driver);
        leavePage.setDatePeriod("2022-07-01","2022-07-31");

    }

    @And("I select to see only leave with Pending Approval status")
    public void iSelectToSeeOnlyLeaveWithPendingApprovalStatus() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.selectPendingApprove();
    }

    @And("I set Leave Type as US - Vacation")
    public void iSetLeaveTypeAsUSVacation() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.selectLeaveType("US - Vacation");
    }

    @And("I press search button")
    public void iPressSearchButton() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.clickSearch();
    }

    @Then("I should see all the records with all the data entered")
    public void iShouldSeeAllTheRecordsWithAllTheDataEntered() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.checkLeaveResults();
        driver.quit();
    }

    //As a user I can verify that the Rejected status is correctly added to the leave records search

    @And("I select the Rejected status from the Show Leave with Status section")
    public void iSelectTheRejectedStatusFromTheShowLeaveWithStatusSection() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.selectRejectedStatus();
    }

    @Then("I check that the Rejected status is present as a selection by using XPath selector")
    public void iCheckThatTheRejectedStatusIsPresentAsASelectionByUsingXPathSelector() {
        LeavePage leavePage =  new LeavePage(driver);
        leavePage.checkRejected();
        driver.quit();
    }

    //As a user I want to see leave records with Pending Approval status for an employee, and then reset the entered data

    @And("I select a period from {int}{int}{int} to {int}{int}{int}")
    public void iSelectAPeriodFromTo(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        LeavePage leavePage =  new LeavePage(driver);
        leavePage.setDatePeriod("2021-12-01", "2023-12-31");
    }

    @And("I select Leave Type as CAN - Personal")
    public void iSelectLeaveTypeAsCANPersonal() {
        LeavePage leavePage =  new LeavePage(driver);
        leavePage.selectLeaveType("CAN - Personal");
    }

    @And("I enter Anthony Nolan in the Employee Name field")
    public void iEnterAnthonyNolanInTheEmployeeNameField() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.setEmployeeName("Daniel Florea");
    }

    @And("I press the Search button")
    public void iPressTheSearchButton() {
        LeavePage leavePage =  new LeavePage(driver);
        leavePage.clickSearch();
    }

    @And("I click on the Reset button")
    public void iClickOnTheResetButton() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.clickReset();
    }

    @Then("I should see a pop-up message that says no records found")
    public void iShouldSeeAPopUpMessageThatSaysNoRecordsFound() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.checkLeaveResults();
        driver.quit();
    }
}