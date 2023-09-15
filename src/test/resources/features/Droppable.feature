@UI
Feature: Droppable

  @Jquery
  Scenario: Drag square to the position
    Given user is on the JqueryUI homepage
    And user choose "Droppable" and click
    Then user hold and drag the square to the position
