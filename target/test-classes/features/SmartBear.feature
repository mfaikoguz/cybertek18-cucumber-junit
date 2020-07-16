@SmartBear
Feature: SmartBear order process

  Scenario: User logs into SmartBear Tester account and on Order Page
    Given User is on the SmartBear login page
    When User enters credentials
    Then User logs in successfully

  Scenario: User clicks OrderPage fills out the form
    #Parameterization
    Given User is on the SmartBear Home page
    Then User selects "FamilyAlbum" from  product dropdown
    And User enters 4 to quantity
    And User enters "John Wick" to customer name
    And User enters "Kinzie Ave" to street
    And User enters "Chicago" to city
    And User enters "IL" to state
    And User  enters "60056" zipcode
    And User selects "Visa" as card type
    And enters "1111222233334444" to card number
    And User enters "12/22" to expiration date
    And User clicks process button
    And User goes to View all orders page
    And User verifies "John Wick" is in the list