@delete
Feature:

  Scenario: As a user I should be able to delete an employee with the DELETE request
    Given I submit a DELETE request for employee id=2
    Then I should have a status-code=200 and employee id=2 should be deleted