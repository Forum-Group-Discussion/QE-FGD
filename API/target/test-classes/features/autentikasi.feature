Feature: Autentikasi
  As a user
  I want to get in to website
  So that i must have an account


  @registration
  Scenario Outline: POST - As a user i have to be able to register
    Given I set an endpoint for new user
    When I request POST user with "<name>" and "<email>" and "<password>" and this user is "<admin>"
    Then I validate the status code <status_code>
    And I validate the "<message>" detail after register

    Examples:
      |name |email|password|admin|status_code| message |
      |adminfound|adminfound@gmail.com|adminfound1511|true|200|success|
      |ihsan|adminfound@gmail.com|           |true|400|password required|
      |ihsan|same                |ihsandududu|true|400|exist email|