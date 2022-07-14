Feature: thread
  As a user
  i want to make a thread
  so that people can see my thread

  @PostThread
  Scenario: POST - As a user i am able to make a thread
    Given I set an endpoint for make a thread
    When I request POST thread
    Then I validate the status code 200
    And I get the data detail

    @PostThreadWithInvalidData
    Scenario Outline: POST - As a user i am not able to make a thread with Invalid Data
      Given I set an endpoint for make a thread
      When I request POST thread with "<data>"
      Then I validate the status code 500
      And I get thread "<error_message>"

      Examples:
      |data|error_message|
      |invalid| data_not_found |
      |  null | internal_server_error|

      @GetThread
      Scenario Outline: GET - As a user i am able to get detail thread
        Given I set an endpoint for get thread with "<id_thread>"
        When I request GET thread with "<id_thread>" and "<token>"
        Then I validate the <status_code> for thread
        And I get the "<detail_thread>" for GET thread

        Examples:
        |id_thread|token|status_code|detail_thread|
        |3        |valid|200        |success      |
        |Covid1   |valid|400        |bad request  |
        |100      |valid|400        |data_not_found|
        |1        |invalid|400        |invalid token      |

        @GetAllThread
        Scenario Outline:  GET- As a user i am able to get list all thread
          Given I set an endpoint for get all thread
          When  I request GET all thread with "<token>"
          Then I validate the <status_code> for thread
          And I get the "<result>" of get all thread

          Examples:
          |token|status_code|result|
          |valid|     200   |success|
          |invalid|     400   |invalid token|







