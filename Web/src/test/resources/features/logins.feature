Feature: Login
  As a user
  i want to Login
  so that i can be an admin or moderator

  Background:
    Given i have registered


  @login
  Scenario Outline: Login scenario
    When i click get started
    And  i input "<email>" and "<password>" for login
    And  i click continue button for login
    Then i get my "<result>" after login

    Examples:
      |email|password|result|
      |adminfound@gmail.com|adminFound1511|homepage|
      |               |SonyaPrds1511|login page|
      |sonya@gmail.com|             |login page|
      |               |             |login page|
      |sonyagmail.com |SonyaPrds1511|invalid email or password|
      |sonya@gmail.com|SonyaPrds    |invalid email or password|
      |sonyagmail.com |SonyaPrds    |invalid email or password|