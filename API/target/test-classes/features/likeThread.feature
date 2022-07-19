Feature: Like Thread
  As a user
  i want to give a like for a thread
  so that the thread can get likes from all users

  @POSTLikeAThread
  Scenario Outline: POST - As a user i want to give comments on a thread
    Given I set an endpoint for make a thread on a comment
    When I request like on a thread by ID thread <id_thread>
    Then I validate the status code <status_code>
    And I get the "<result>" comment

    Examples:
    |id_thread|status_code|result|
    |7        |200        |success|
    |100      |400        |data not found|




