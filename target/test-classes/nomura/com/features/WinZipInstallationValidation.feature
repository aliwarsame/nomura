@nomura
Feature: Validate Winzip installation on new build in virtualbox Windows machine

  Scenario: Validate windows native file explorer
    Given virtualbox virtual machine installed with Windows 10
    When a zip file is selected for extraction
    Then the windows file explorer should be visible
#    And the license pop up should not be displayed

  Scenario: Validate Winzip v 22.0.12706 installation on new build virtualbox machine
    Given virtualbox virtual machine installed with Windows 10
    When I check the registry key for package GUID "{CD95F661-A5C4-44F5-A6AA-ECDD91C24119}" in HKEY
    Then the entry should be present
    When the "winzip64.exe" file in "C:\Program Files\Winzip" is clicked
    Then the winzip screen should be visible
    And the license pop up should not be displayed
