@Shopping
Feature: Amazon Shopping Cart Management

  Scenario Outline: Manage items in the cart
    Given I go to amazon.com
    When I click on "Today's Deals"
#    And I sort the items by "Discount: High to Low"
    And I select filter Discount "70% off or more"
    And I view the deal for the "2nd" item
    And I add "<deal_quantity>" of the item into the cart
    And I go back to the main page
    And I search for "<search_item>"
    And I sort the items by "Feature"
    And I add "<search_quantity>" of the searched item into the cart
    And I go to my cart
    And I edit the "1st" item quantity to "<edited_first_item_quantity>"
    And I edit the "2nd" item quantity to "<edited_second_item_quantity>"
    And I delete the "1st" item
    And I click "Proceed to Checkout"
    Then I should see "<expected_second_item_quantity>" of the "<order_in_cart>" item in the cart
    And I should see the price for "<expected_second_item_quantity>" items of the second item

    Examples:
      | deal_quantity | search_item   | search_quantity | edited_first_item_quantity | edited_second_item_quantity | expected_second_item_quantity |
      | 2             | AAA Batteries | 5               | 1                          | 3                           | 3                             |
