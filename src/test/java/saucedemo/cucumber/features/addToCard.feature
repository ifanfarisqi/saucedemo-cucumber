Feature: Add to Cart Feature

  Scenario: Add a product to the cart
    Given User is on login pages
    When User enter registered account
    And User push button login
    Then User should see inventory pages
    When User clicks on the add to cart button
    And User clicks on icon wishlist
    Then User should see cart page
