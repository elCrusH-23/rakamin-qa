Feature: item remove
  Scenario: Remove item in cart
    Given  open browser to login
    And Located saucedemo website
    And Input username valid
    And Input password valid
    And Click the login button
    And clik add cart button
    And Go to  cart menu
    When deleted item in cart
    Then Go back to product menu