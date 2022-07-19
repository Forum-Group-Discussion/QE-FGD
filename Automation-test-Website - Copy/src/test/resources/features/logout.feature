Feature: Logout

  As a user
  I want to logged out from website
  So that my account not logged in website

  @logout
  Scenario: Logout scenario
    Given i am on homepage
    When i click logout
    Then i get landing page


