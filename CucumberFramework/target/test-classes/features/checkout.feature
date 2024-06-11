@PlaceOrder
Feature: Search and place the order for products
  Scenario Outline: Search experience for product search in both home and offer page
    Given User is on Greenkart landing page
    When User searched with shortname <Name> and extracted the actual name of the product
    And Added "3" items of the selected product to cart
    Then User proceeds to Checkout and validate the <Name> items in checkout page
    And Verify user has ability to enter promocode and place the order
Examples:
|Name|
|Tom|
