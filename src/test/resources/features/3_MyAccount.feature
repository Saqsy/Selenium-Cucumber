# author Saquib Kazi
# Feature File to test My Account Page Functionality

@MyAccount
Feature: My Account Testing
  Testing Account Section of McDonalds WebApplication

  @Payments
  Scenario: Payments section in Account Settings
    Given The User is logged in the application
    When Clicked on My Account hyperlink
    And Clicked on Payments hyperlink
    Then User is redirected to Payments Page

  @Address
  Scenario: Saved Address Section in Account Settings
    Given User is in My Accounts Page
    When Clicked on Saved Addresses hyperlink
    Then User is redirected to Saved Addresses page
    
  @MyAccountOffer
  Scenario: User should be redirected to offers page
  Given User had navigated to My Accounts Page
  When Click on Offers hyperLink
  Then User is redirected to Offer Page
