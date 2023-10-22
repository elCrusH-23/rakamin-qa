Feature: loginFail
  Scenario: Failed login to saucedemo with empty username
    Given  open Browser
    And  Located saucedemo
    And Input username "xxxx" and password "secret_sauce"
    When click login button
    Then Error message