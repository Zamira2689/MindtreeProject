@get
Feature: API task

  Scenario: As a user I should be able to list an employee with the GET request
    Given I submit a GET request with employee id=1
    Then I should have status-code=200 and employee id=1 should be listed