Feature: Filter Product Feature

  Scenario: Filter product for a product by name
    Given User on login page
    When User enter registered username and password
    And User press button login
    Then User should see inventory page
    And User should see products
    When User clicks list product on the filter button
    And User select list product in the filters list bar
    Then User should see a list of matching products