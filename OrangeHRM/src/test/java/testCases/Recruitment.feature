Feature: Recruitment

  Scenario: As a user I can see all the Junior Account Assistant vacancies
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click on the Recruitment option from the menu
    And I click on the Vacancies option
    And I search for vacancies with job title as Junior Account Assistant
    Then I can see that all records are displayed for Junior Account Assistant

  Scenario: As a user I am able to schedule an interview with a candidate
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click on the Recruitment option from the menu
    And I click on the view icon located in the Actions section to see a candidate's application in Status Shortlisted
    And I click the Schedule Interview button for that candidate
    And I add the title of the interview
    And I add two interviewers in the Interviewer field
    And I select a date and hour
    And I press the Save button to schedule the interview
    Then I should see the confirmation message for this scheduled interview