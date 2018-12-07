Feature: Connexion

  Scenario Outline: login with correct creentials
    Given user is already in login page
    And user enters <username> and <password>
    When user click on login
    Then system redirect to home page

    Examples:
      | username | password  |
      | hsedjame | hiphop!87 |

