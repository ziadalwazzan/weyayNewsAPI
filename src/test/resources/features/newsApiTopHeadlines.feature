Feature: News Api Top Headlines

  Scenario: Top Headlines
    Given A top headlines request for "fr"
    When The client requests top headlines
    Then the result should be the expected top headlines data object