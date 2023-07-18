Feature: Login to OrangeHRM

  Scenario: Login with invalid credentials
    Given I access OrangeHRM page
    When I enter invalid login credentials
    And I press the Login button to log into my account
    Then I verify that an appropriate message is displayed for invalid credentials

  Scenario:
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    Then I verify that I am logged into my account by checking that the username is displayed