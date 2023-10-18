Feature: Login Feature

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks on the login button
    Then User should be redirected to the home page
    And User should see the products

  Scenario: Login with invalid credentials
    Given User is on the login page
    When User enters invalid username or password
    And User clicks on the login button
    Then User should see an error message
