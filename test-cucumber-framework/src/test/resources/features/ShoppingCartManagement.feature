@CheckoutCart
Feature: Amazon Shopping Cart Management

  Scenario Outline: Manage items in the cart
    Given I go to amazon.com
    And I input Captcha manually if required with timeout "90" seconds
    When I click on menu "Today's Deals"
#    And I sort the items by "Discount: High to Low"
    And I select filter Discount "70% off or more"
    And I view the deal for the "<deal_item>" item
    And I add "<deal_quantity>" of the item into the cart
    And I go back to the main page
    And I search for "<search_item>"
    And I sort the items by "Featured"
    And I add "<search_quantity>" of the searched item into the cart
    And I go to my cart
    When I edit the "1st" item quantity to "<edited_first_item_quantity>"
    Then I should see the price for "<expected_item_quantity>" items in the cart
    When I edit the "2nd" item quantity to "<edited_second_item_quantity>"
    And I delete the "1st" item
    Then I should see the price for "<expected_item_quantity>" items in the cart
    And I click on "Proceed to checkout" on the cart page

    Examples:
      | deal_item | deal_quantity | search_item   | search_quantity | edited_first_item_quantity | edited_second_item_quantity | expected_item_quantity |
      | 2nd       | 2             | AAA Batteries | 5               | 1                          | 3                           | 3                      |
