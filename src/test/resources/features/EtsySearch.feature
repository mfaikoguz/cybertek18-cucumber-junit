@etsy
Feature: Etsy Search
  Agile Story: User should be able to enter search terms and see
  relevant results in the page and in the title

  Background: User is on the Etsy home page
    Given User is on the Etsy home page


  Scenario: Title verification
    Then User should see title is as expected

    # expected: Etsy -Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Search Functionality Title Verification without parameterization
    When User searches wooden spoon and click
    Then User should see  Wooden spoon in the title

  Scenario: Search Functionality Title Verification with parameterization
    When User searches "Wooden spoon" and click
    Then User should see "Wooden spoon" in the Etsy title
