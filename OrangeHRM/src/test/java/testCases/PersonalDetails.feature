Feature: Personal Details

  Scenario: I can change my profile picture
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the My Info option from the menu
    And I click on the profile picture
    And I add a picture
    And I click the Save button
    Then I can see that my profile picture has been updated