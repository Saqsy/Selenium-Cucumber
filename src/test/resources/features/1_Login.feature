# author Saquib Kazi
# Feature File to test Login Functionality with valid Credentials

@Login
Feature: Login to the application

Background:
Given Something will happen

Scenario: Testing the login functionality with the valid user credentials
Given when the user is in the HomePage
When The user clicks on Login/Sign Up link
And The user clicks Login Via Password option
And The user enters valid username "<username>" and password "<password>"
Then the system allows the user to login and navigate to the HOME page

Examples:

|username  |password      |
|1234567890|skvdfhfbnsdsf |
