Feature: Post

  Scenario: Create Post
    Given user is logged in
      | username | chenlena@outlook.com |
      | password |               798911 |
    When user navigates to the Posts page
    And user enter the post content
      | content               |
      | Where is my cucumber? |
    And user clicks on the submit button
    Then user should see a success alert that says "Post Created"
