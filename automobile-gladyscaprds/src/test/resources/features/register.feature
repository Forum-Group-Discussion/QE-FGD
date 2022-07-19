Feature: Registration
  As a user
  i want to register
  so that i have an account to login into website

  Background:
    Given i am on landing page

@regis
  Scenario Outline: Registration scenario
    When i click icon account and register
    And  i input "<username>" my name
    And  i input "<email>" my email
    And  i input "<password>" my password
    And  i input "<confirm password>"
    And  i click register button
    Then i get my "<result>"

    Examples:
      |username|email|password|confirm password|result|
      |kowboy|kowboy@gmail.com|kowboy|kowboy|new user|

