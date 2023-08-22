package pageObject;

public interface Global {
    String configurationButton = "//span[text() = 'Configuration ']";
    String languagePackageButton = "//a[text() = 'Language Packages']";
    String addButton = "//button[text() = ' Add ']";
    String saveButton = "//button[text() = ' Save ']";
    String successToast = "//div[contains(@class, 'oxd-toast oxd-toast--success')]";
    String usernameField = "//input[contains(@name, 'username')]";
    String passwordField = "//input[contains(@name, 'password')]";
    String loginButton = "//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]";
    String forgotPasswordButton = "//div[contains(@class, 'orangehrm-login-forgot')]/p";
    String street1Field = "(//input[contains(@class, 'oxd-input oxd-input--active')])[2]";
}
