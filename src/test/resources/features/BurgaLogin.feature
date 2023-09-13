@UI
Feature: Burga Login

  @Burga
  Scenario: Log on to Burga
    Given user is on the Burga home page
    Then user inputs credentials
      | Email address | chenjiayu632@gmail.com |
      | password      |                 798911 |
    And user clicks LOG IN button
    Then user is on the Burga profile homepage
