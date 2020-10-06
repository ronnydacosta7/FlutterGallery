# new feature
# Tags: optional

Feature: Clear Shopping Card

  Scenario: User wants to clear shopping card
    Given User open the Shire Gallery
    When click on next button after user input username & password
    And click on filter menu
    And click on clothing filter
    And click on item sea tunic
    And the item sea tunic add to shopping card
    And click clear cart
    Then there is no item in the shopping card