# author Saquib Kazi
# Feature File to apply a coupon from Offers Page

@Offers
Feature: Apply Offer Coupons on Eligible Orders
Scenario: User should be able to apply coupons on eligible orders
Given User is logged into the application
When User has added food to the cart
And Clicked on Offers link
And User chooses a Coupon Code and clicks Apply
Then Coupon Code is Successfully Applied
