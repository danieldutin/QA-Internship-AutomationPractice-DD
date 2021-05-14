Feature: Cart feature

  After user adding products to the cart - the cart content must contain the exact products that user initially added.

  Scenario: Successfully adding items to the cart

    Given User is on the home page of the Automation Practice online store
    When User add 5 products to the cart
    And User click on go to checkout
    Then All initially added products are available in the checkout summary