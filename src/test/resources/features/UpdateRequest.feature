@update
Feature: API Task


  Scenario: As a user I should be able to update an employee detail with the PUT request
    Given I submit a PUT request for employee id=1 with salary change
    Then I should have status-code=200 and employee id=1 salary has updated
