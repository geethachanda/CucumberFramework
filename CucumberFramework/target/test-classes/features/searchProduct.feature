@OffersPage
Feature: Search and place the order for products
  Scenario Outline: Search experience for product search in both home and offer page
    Given User is on Greenkart landing page
    When User searched with shortname <Name> and extracted the actual name of the product
    Then User searched for same shortname <Name> in offer page to check if product exist
    And Validate product in Offers Page matches with Landing Page
    
Examples:
|Name|
|Tom|
|Beet|