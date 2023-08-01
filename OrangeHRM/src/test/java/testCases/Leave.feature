Feature: Leave Page

  Scenario: As a user I can add a comment for a leave request
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Leave link from the menu
    And I click on the button with three dots which is located in the left corner for an employee record
    And I select to Add Comment from that list
    And I enter a comment in the Leave Request Comments section
    And I save the comment
    Then I should be able to see the confirmation message that the comment was added successfully