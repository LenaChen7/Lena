@Nike
Feature: Nike

  Scenario: Product Search
    Given user is on the Nike homepage
    And user searches for "Air Jordan"
    Then user should see search results for "Air Jordan"
