# new feature
# Tags: optional

Feature: Remove Item

  Scenario: User wants to remove an item on the shopping cart
    Given User open the Shire Gallery
    When click on next button after user input username & password
    And click on filter menu
    And click on clothing filter
    And click on item sea tunic
    And the item sea tunic add to shopping card
    And click on remove item button
    Then the item will be deleted from shopping card
