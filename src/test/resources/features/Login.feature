@Login
Feature: Login

  @UI
  Scenario: Happy Path
    Given user is on the boratech homepage
    When user navigates to the Login page
    And user enters the username - "chenlena@outlook.com" and password - "798911" and submit
    Then user should be on the Dashboard page
#
  #@UI
  #Scenario Outline: Unhappy Path
    #Given user is on the boratech homepage
    #When user navigates to the Login page
    #And user enters the username - "<email>" and password - "<password>" and submit
    #Then user should see a login error
#
    #Examples: 
      #| email                  | password |
      #| chenlena@outlook.com   |   798911 |
      #| jin@boratechschool.com |   798911 |
#
  #@API
  #Scenario: API - Happy Path
    #Given [API] user is logged in
      #| username | chenlena@outlook.com |
      #| password |               798911 |
#
  #@API
  #Scenario Outline: API - Unhappy Path
    #Given [API] user tries to login
      #| email    | <email>    |
      #| password | <password> |
    #Then [API] user should receive login errors
      #| error | <error> |
#
    #Examples: 
      #| email                            | password | error                |
      #| muradil.erkin@boratechschool.com |          | Password is required |
      #|                                  |          | Email is required    |
      #|                                  | BoraTech | Email is required    |
