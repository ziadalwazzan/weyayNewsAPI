Feature: News Api Sources

  Scenario: Sources
    Given I request sources
    When I fetch sources
    Then the result should be a populated sources data object