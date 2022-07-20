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
      |Martin|martin@gmail.com|Martin1511|Martin1511|new user|
      |Joshua|joshua@gmail.com|           |          |registration page|
      |      |joshua@gmail.com|Joshua2001 |Joshua2001|registration page|
      |Joshua|                |Joshua2001 |Joshua2001|registration page|
      |      |                |           |          |registration page|
      |      |                |Joshua2001 |Joshua2001|registration page|
      |Joshua|                |           |          |registration page|
      |      |joshua@gmail.com|           |Joshua2001|registration page|
      |      |joshua@gmail.com|           |Joshua2001|registration page|
      |sonyapardosi|sonyaprds@gmail.com|Sonya1511|Sonya1511|registration page|
      |nelapardosi |sonyaprds@gmail.com|Nela1511|Nela1511|registration page|
      |Martin|martinsiahaan@gmail.com|Martin1511|Martin1511|new user|
      |sonyapardosi|sonyaprds@gmail.com|SonyaAhnela1511|SonyaAhnela1511|registration page|