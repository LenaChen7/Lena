Feature: Login
  
  Scenario: Happy Path
    Given user is on the boratech homepage
    When user navigates to the Login page
    And user enters the username - "chenlena@outlook.com" and password - "798911" and submit
    Then user should be on the Dashboard page

 