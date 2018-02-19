$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CheckWindowsServicestatus.feature");
formatter.feature({
  "line": 1,
  "name": "Check Windows services status",
  "description": "As a Windows build engineer\nI want to check the state of services which are running on a built platform\nSo that I can check that services required for user applicaions are running on a new build",
  "id": "check-windows-services-status",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 7,
  "name": "check Windows Time service is running",
  "description": "",
  "id": "check-windows-services-status;check-windows-time-service-is-running",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@nomura"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "virtualbox virtual machine installed with Windows 10",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I inspect \"\u003cservice\u003e\" for \"\u003cproperty\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the value should be \"\u003cvalue\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "check-windows-services-status;check-windows-time-service-is-running;",
  "rows": [
    {
      "cells": [
        "service",
        "property",
        "value"
      ],
      "line": 13,
      "id": "check-windows-services-status;check-windows-time-service-is-running;;1"
    },
    {
      "cells": [
        "w32time",
        "State",
        "Stopped"
      ],
      "line": 14,
      "id": "check-windows-services-status;check-windows-time-service-is-running;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
  "name": "check Windows Time service is running",
  "description": "",
  "id": "check-windows-services-status;check-windows-time-service-is-running;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@nomura"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "virtualbox virtual machine installed with Windows 10",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I inspect \"w32time\" for \"State\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the value should be \"Stopped\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 50
    }
  ],
  "location": "CheckWindowsServiceStatus.virtualbox_virtual_machine_installed_with_Windows(String)"
});
formatter.result({
  "duration": 4105875176,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "w32time",
      "offset": 11
    },
    {
      "val": "State",
      "offset": 25
    }
  ],
  "location": "CheckWindowsServiceStatus.I_inspect_for(String,String)"
});
formatter.result({
  "duration": 31459172694,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Stopped",
      "offset": 21
    }
  ],
  "location": "CheckWindowsServiceStatus.the_value_should_be(String)"
});
formatter.result({
  "duration": 2963256,
  "status": "passed"
});
formatter.uri("WinZipInstallationValidation.feature");
formatter.feature({
  "line": 2,
  "name": "Validate Winzip installation on new build in virtualbox Windows machine",
  "description": "",
  "id": "validate-winzip-installation-on-new-build-in-virtualbox-windows-machine",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@nomura"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Validate windows native file explorer",
  "description": "",
  "id": "validate-winzip-installation-on-new-build-in-virtualbox-windows-machine;validate-windows-native-file-explorer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "virtualbox virtual machine installed with Windows 10",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a zip file is selected for extraction",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the windows file explorer should be visible",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 50
    }
  ],
  "location": "CheckWindowsServiceStatus.virtualbox_virtual_machine_installed_with_Windows(String)"
});
formatter.result({
  "duration": 2435034329,
  "status": "passed"
});
formatter.match({
  "location": "WinZipInstallationValidation.a_zip_file_is_selected_for_extraction()"
});
formatter.result({
  "duration": 26248755016,
  "status": "passed"
});
formatter.match({
  "location": "WinZipInstallationValidation.the_windows_file_explorer_should_be_visible()"
});
formatter.result({
  "duration": 11613182308,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 8,
      "value": "#    And the license pop up should not be displayed"
    }
  ],
  "line": 10,
  "name": "Validate Winzip v 22.0.12706 installation on new build virtualbox machine",
  "description": "",
  "id": "validate-winzip-installation-on-new-build-in-virtualbox-windows-machine;validate-winzip-v-22.0.12706-installation-on-new-build-virtualbox-machine",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "virtualbox virtual machine installed with Windows 10",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I check the registry key for package GUID \"{CD95F661-A5C4-44F5-A6AA-ECDD91C24119}\" in HKEY",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the entry should be present",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "the \"winzip64.exe\" file in \"C:\\Program Files\\Winzip\" is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the winzip screen should be visible",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the license pop up should not be displayed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 50
    }
  ],
  "location": "CheckWindowsServiceStatus.virtualbox_virtual_machine_installed_with_Windows(String)"
});
formatter.result({
  "duration": 1536953037,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "{CD95F661-A5C4-44F5-A6AA-ECDD91C24119}",
      "offset": 43
    }
  ],
  "location": "WinZipInstallationValidation.i_check_the_registry_key_for_package_GUID_in_HKEY(String)"
});
formatter.result({
  "duration": 30959297092,
  "status": "passed"
});
formatter.match({
  "location": "WinZipInstallationValidation.the_entry_should_be_present()"
});
formatter.result({
  "duration": 2989152,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "winzip64.exe",
      "offset": 5
    },
    {
      "val": "C:\\Program Files\\Winzip",
      "offset": 28
    }
  ],
  "location": "WinZipInstallationValidation.the_file_in_is_clicked(String,String)"
});
formatter.result({
  "duration": 2369866683,
  "status": "passed"
});
formatter.match({
  "location": "WinZipInstallationValidation.the_winzip_screen_should_be_visible()"
});
formatter.result({
  "duration": 46944,
  "status": "passed"
});
formatter.match({
  "location": "WinZipInstallationValidation.the_license_pop_up_should_not_be_displayed()"
});
formatter.result({
  "duration": 60625049960,
  "error_message": "org.openqa.selenium.NoSuchElementException: Element cannot be found (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 60.62 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.48.2\u0027, revision: \u002741bccdd10cf2c0560f637404c2d96164b67d9d67\u0027, time: \u00272015-10-09 13:08:06\u0027\nSystem info: host: \u0027Alis-MacBook-Pro.local\u0027, ip: \u0027172.20.10.8\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.12.6\u0027, java.version: \u00271.8.0_121\u0027\nDriver info: org.openqa.selenium.winium.WiniumDriver\nCapabilities [{app\u003dC:\\Program Files\\Winzip\\winzip64.exe, args\u003d, innerPort\u003d9998, debugConnectToRunningApp\u003dfalse, keyboardSimulator\u003d1, launchDelay\u003d2, platform\u003dANY}]\nSession ID: AwesomeSession\n*** Element info: {Using\u003dname, value\u003dBuy Now}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:647)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:353)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByName(RemoteWebDriver.java:451)\n\tat org.openqa.selenium.By$ByName.findElement(By.java:303)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:345)\n\tat nomura.com.stepdefs.WinZipInstallationValidation.the_license_pop_up_should_not_be_displayed(WinZipInstallationValidation.java:120)\n\tat ✽.And the license pop up should not be displayed(WinZipInstallationValidation.feature:16)\n",
  "status": "failed"
});
});