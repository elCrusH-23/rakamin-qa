Feature: Rakamin test
  Scenario: Login Succes
    Given I open browser
    And Open website saucedemo
    And Located on saucedemo website
    When Input valid username
    And Input valid password
    And Click button login
    Then Should Succes login and redirected to homepage

