Feature: Registration
  As a user
  i want to register
  so that i have an account to login into website

  Background:
    Given i access the web

  @register
  Scenario Outline: Registration scenario
    When i click get started
    And  i click sign up
    And  i input "<username>" and "<email>" and "<password>" and "<confirm password>"
    And  i click continue button
    Then i get my "<result>"

    Examples:
      |username|email|password|confirm password|result|
      |sonyaprds|sonya@gmail.com|SonyaPrds1511|SonyaPrds1511|new user|
      |         |sonya@gmail.com|SonyaPrds1511|SonyaPrds1511|register page|
      |sonyaprds|         |SonyaPrds1511|SonyaPrds1511|null|
      |sonyaprds|sonya@gmail.com|        |SonyaPrds1511|register page|
      |sonyaprds|sonya@gmail.com|SonyaPrds1511|        |register page|
      |sonyaprds|sonya@gmail.com|SonyaPrds1511|SonyaPrds1|register page|
      |               |               |        |          |null|
      |son             |sonya@gmail.com|SonyaPrds1511|SonyaPrds1|register page|
      |sonyaprds  |sonya@gmailcom|SonyaPrds1511|SonyaPrds1|register page|
      |sonyaprds  |sonya@gmailcom|SonyaPrds|SonyaPrds1|register page|









