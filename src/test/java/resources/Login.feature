Feature: Login functionality

  In order to use the automation practice online store
  a valid registered user must be able to login successfully.

  Scenario: Successful Login

    Given User is on the login page of the Automation Practice online store
    When Valid credentials are entered
    Then User must be redirected to My Account Page

  Scenario: Login denied - invalid credentials

    Given User is on the login page
    When Invalid credentials are entered
    Then Error message must be displayed