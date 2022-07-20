Feature: Login

  Scenario Outline: Login scenario
    Given i am on login page
    When i input "<email>" username
    And i input "<password>" password
    And click login button
    Then i get the "<result>"
    Examples:
      |email|password|result|
      |yolandaManurung@gmail.com|Yolanda1511|home page|
      |yolandaManurung@gmail.com|           |login page|
      |                         |Yolanda1511|login page|
      |                         |           |login page|
      |yolanda@gmail.com        |Yolanda1511|login page|
      |yolandaManurung@gmail.com|yolandaaa1511|login page|
      |yolanda@gmail.com|yolandaaa1511|login page|





