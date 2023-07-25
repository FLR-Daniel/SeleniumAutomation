Feature: Login to OrangeHRM

  Scenario: Login with invalid credentials
    Given I access OrangeHRM page
    When I enter invalid login credentials
    And I press the Login button to log into my account
    Then I verify that an appropriate message is displayed for invalid credentials

  Scenario: Login with valid credentials
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    Then I verify that I am logged into my account by checking that the username is displayed

  Scenario: As a user I am able to change my password
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I select the Change Password option from drop-down user profile menu
    And I enter the current password in the Current Password field
    And I enter in the Password field a new password
    And I confirm the new password
    And I press the Save button to update the password
    Then I should be able to see the confirmation message