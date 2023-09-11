Feature: Burga
  
  @Burga
  Scenario: Add an item into shopping cart
    Given user is on the Burga homepage
    And user clicks a product type on the top bar 
    And user adds one item - "Almond Latte" into the shopping cart
    Then user views cart
    
    

 