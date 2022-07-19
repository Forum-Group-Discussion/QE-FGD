Feature: Comment
  As a user
  i want to comment on a thread
  so that i can give my opinion on the thread

  @POSTComment
  Scenario Outline: POST - As a user i want to give a comments on a thread
    Given I set an endpoint for make a thread on a comment
    When I request comment on a thread by ID thread <id_thread>
    Then I validate the status code <status_code>
    And I get the "<result>" comment

    Examples:
   |id_thread|status_code|result|
    |8        | 200       |success|
    |100      | 400       |failed |

    @GetCommentSByIdThread
    Scenario Outline: Get Comments By id thread
      Given I set an endpoint for GET comment by ID thread <id_thread>
      When I request GET comment by ID thread <id_thread>
      Then I validate the status code <status_code>
      And I get the "<result>" based on id thread <id_thread>

      Examples:
      |id_thread|status_code|result|
      |15|200|success|
      |2|400|data not found|


      @DeleteCommentsById
      Scenario Outline: Delete comments By Id comments
        Given I set an endpoint for delete comments by ID Thread <id_thread>
        When I request DELETE Comment by ID Thread <id_thread>
        Then I validate the status code <status_code>
        And I get the "<result>" for comment

        Examples:
          |id_thread|status_code|result|
          |19|200|success              |
          |2|400|data not found        |

