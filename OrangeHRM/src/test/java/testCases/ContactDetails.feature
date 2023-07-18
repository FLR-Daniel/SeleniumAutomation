Feature: Contact Details

  Scenario: I am able to update my street and country details
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the My Info option from the menu
    And I click on the Contact Details link which will redirect me to the contactDetails page
    And I update the Street 1 field from contact details
    And I select Algeria as country
    And I press the Save button
    Then I should see the successfully updated confirmation message

  Scenario: I am able to add an attachment into my Contact Details
    Given I access OrangeHRM page
    When I enter valid login credentials
    And I press the Login button to log into my account
    And I click the My Info option from the menu
    And I click on the Contact Details link which will redirect me to the contactDetails page
    And I click the Add Attachments button
    And I select to upload a file
    And I add a comment for this document uploaded in the comment field
    And I press the Save button for this attachment added
    Then I am able to see my document added in the record found section by using css selector