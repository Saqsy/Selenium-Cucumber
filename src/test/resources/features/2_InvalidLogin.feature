# author Saquib Kazi
# Feature File to test Login Functionality with invalid Credentials
# Case 1 - valid username and invalid password
# Case 2 - invalid Username and valid Password

@InvalidLogin
Feature: Try to Login to the application with invalid credentials
Scenario: Testing the login functionality with the invalid user credentials
Given when the user opens HomePage
When The User clicks on Login and Sign-Up link
And The User clicks Login Via Password hyperlink
And The User enters "<value1>" "<username>" and "<value2>" "<password>"
Then The system throws a message saying invalid username/password

Examples:

|value2          |value1           |username  |password      |
|invalid password|valid username   |1234567890|Anfcgvhjedcv|
|valid password |invalid username |0987654321|Tbdnslfjbv |