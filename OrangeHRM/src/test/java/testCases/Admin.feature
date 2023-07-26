Feature: Admin commands

  Scenario: I am able to access the Language Packages
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link from the menu
    And I click on the Configuration dropdown menu button
    And I click on the Language Packages option
    And I click on the Translate button for Spanish - Español language package
    Then I should be redirected to the languageCustomization page

  Scenario: As a user I am able to add a new Language Package
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link from the menu
    And I click on the Configuration dropdown menu button
    And I click on the Language Packages option
    And I click the Add button to add a new language to the packages
    And I select the language Colognian(Germany) from that list
    And I press the Save to add this new language to my packages
    Then I should be able to see the confirmation message that the language was successfully saved

  Scenario: As a user I want to add a new job
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the Admin link from the menu
    And I select the Job Titles option from the Job menu dropdown
    And I click the Add button to add a new job
    And I add a name for the job in the Job Title field
    And I add a job description
    And I add a Job Specification file
    And I click the Save button to add the new job
    Then I should see the confirmation message that the job was successfully added