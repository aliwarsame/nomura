Feature: Check Windows services status
  As a Windows build engineer
  I want to check the state of services which are running on a built platform
  So that I can check that services required for user applicaions are running on a new build

  @nomura
  Scenario Outline: check Windows Time service is running
    Given virtualbox virtual machine installed with Windows 10
    When I inspect "<service>" for "<property>"
    Then the value should be "<value>"

    Examples:
      | service | property | value   |
      | w32time | State    | Stopped |
