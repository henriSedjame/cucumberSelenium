Feature: save action

  Scenario: save successfully
    Given i'm ready to save something
    When i enter Username and Password
      | Username | Password |
      | henri    | henri    |
    Then everything is ok