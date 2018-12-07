Feature: save action

  Scenario: save successfully
    Given i'm ready to save something
    When i enter Username and Password
      | Username | Password |
      | henri    | henri    |
    Then everything is ok

  Scenario Outline:
    Given i'm ready to save something
    When i enter <Username> and <Password>
    Then everything is ok
    Examples:
      | Username | Password |
      | henri    | henri    |