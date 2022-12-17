@post
Feature: API task

  Scenario: As a user I should be able to add an employee with the POST request
    Given I submit a POST request with given employee details
    Then I should have status-code=200 and a new employee should be created
