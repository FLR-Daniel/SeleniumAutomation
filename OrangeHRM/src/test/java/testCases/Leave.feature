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

  Scenario: As a user I want to see all the vacation leave records for a certain period
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Leave link from the menu
    And I select a specific period for which I want to see the records
    And I select to see only leave with Pending Approval status
    And I set Leave Type as US - Vacation
    And I press search button
    Then I should see all the records with all the data entered