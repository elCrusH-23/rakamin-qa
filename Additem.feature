Feature: item to cart menu
  Scenario: Add item to cart
    Given open browser login
    And Located saucedemo website at login page
    And Input username validate
    And Input password validate
    And click login button with click
    When click item and click add cart button
    Then Go to the cart menu