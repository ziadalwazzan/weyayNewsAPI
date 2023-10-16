Feature: Calculator operations

  Scenario: Top Headlines
    Given I get a request for the top headlines of France
    When I make the request
    Then the result should pass