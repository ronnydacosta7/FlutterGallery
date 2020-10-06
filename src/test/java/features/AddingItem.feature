# new feature
# Tags: optional

Feature: Adding item to shopping card

  Scenario: User want add item sea tunic to shopping card
    Given User open the Shire Gallery
    When click on next button after user input username & password
    And click on filter menu
    And click on clothing filter
    And click on item sea tunic
    Then the item sea tunic add to shopping card

  Scenario: User want to add sea tunic and stella sunglasses
    Given User open the Shire Gallery
    When click on next button after user input username & password
    And click on filter menu
    And click on accessories filter
    And click on item stella sunglasses
    And click on filter menu
    And click on clothing filter
    And click on item sea tunic
    Then the item sea tunic and stella sunglasses add to shopping card


