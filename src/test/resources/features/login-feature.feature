#Feature: Users should be able to Login to automation practice app
#
#  Scenario: Check Login Page Title
#    Given User is not logged in home page
#    When User visit login page
#    Then The login page title should be "Login - My Store"
#
#  Scenario: Check Forget Password is displayed in Login Page Title
#    Given User is not logged in home page
#    When User visit login page
#    Then The user should see forget password link
#
#  Scenario: Check that user can login with valid credentials
#    Given User is not logged in home page
#    When User visit login page
#    And User enters valid credentials
#    Then The user is should see "MY ACCOUNT" label
#    Then The account title should be "My account - My Store"