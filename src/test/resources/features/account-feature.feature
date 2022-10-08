Feature: Account Page Feature

  Background:
    Given user has already logged in to application

  Scenario: Check sections inside my account
    Given user is on Accounts page
    When user checks the available sections
    Then user should see 5 sections
      | section                   |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS           |
