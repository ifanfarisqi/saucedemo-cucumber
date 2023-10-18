Feature: Checkout Feature

  Scenario: Proceed to checkout with added products in the cart
    Given User is on login page
    When User enters registered account
    And User click button login
    Then User will see inventory pages
    When User click add to cart button
    And User click icon wishlist
    Then User will see cart page
    And User clicks on button checkout
    Then User should be redirected to the checkout your information page
    When User enters valid firstname,lastname and zip
    And User clicks on button continue
    Then User should be redirected to the checkout your checkout overview page
    And User clicks on button finish
    And User clicks on the back home button
    Then User should be redirected to the inventory page
