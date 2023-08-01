Feature: PIM

  Scenario: As a user I am able to add a new employee

    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click on the PIM option from the menu
    And I choose the Add Employee option
    And I add a profile picture for that employee
    And I enter the employee's full name in the Employee Full Name section
    And I enter an employee id in the Employee Id field
    And I click the Create Login Details button to make the option available
    And I add a username and password
    And I press the Save button
    Then I should see a confirmation message that the employee was successfully saved