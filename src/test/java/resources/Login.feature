Feature: Login functionality

  In order to use the automation practice online store
  a valid registered user must be able to login successfully.

  Scenario: Successful Login

    Given User is on the home page of the Automation Practice online store
    When When user click on Sign In button
    Then The login page is available for the user
    When User enter valid credentials
    And  User click on Login button
    Then User must be redirected to My Account Page

  Scenario: Login denied - invalid credentials

    Given User is on the home page
    When When user click on SignIn button
    Then The login page is available for user
    When Invalid credentials are entered
    And  User clicks on Login button
    Then Error message must be displayed