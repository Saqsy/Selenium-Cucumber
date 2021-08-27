# author Saquib Kazi
# Feature File to test Help Center Page Functionality

@HelpCenter
Feature: Testing HelpCenter Page Functionality
Description: This feature will check the Help Center Page.

Background: User is logged in the application and in the My Account Page
Given Open HomePage and Enter Credentials
When I click on My Account Page
Then I should be on My Account Page


  @HelpWithOrders
  Scenario: User is able to raise queries on previous orders
    When User click the Help Center hyperlink in My Account
    Then User is able to choose previous orders for query

  @GeneralQueries
  Scenario: User is able to view General Queries
    When User clicks on General Queries hyperlink
    Then List of frequent queries and answers appear on the page
    
   @Legal
   Scenario: Terms & Conditions and Privacy Policy is visible to the User
   When User clicks on Legel hyperlink
   Then Term & Conditions and Privacy Policy are visible to the user
   
   @FAQS
   Scenario: User is able to view frequently asked questions
   When User clicks on FAQS hyperlink
   Then Frequently asked questions are visible to the user
   
   @Feedback
   Scenario: User is able to get a feedback form
   When User click on Feedback hyperlink
   Then User is redirected to Feedback page