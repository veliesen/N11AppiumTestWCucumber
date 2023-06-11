Feature: Selendroid APK TEST CASES

  Scenario: Test Case TC0001
    Given Selendroid APK OPEN
    When Continue button clicked
    And Selendroid info popup closed
    And Input sendkeys "TestQA"


  Scenario: Test Case TC0002
    Given Selendroid APK OPEN
    When Continue button clicked
    And Selendroid info popup closed
    And Input sendkeys "TestQA"
    And Display Text View
    And Displays a Toast
    And Displays popup window button click

  Scenario: Test Case TC0003
    Given Selendroid APK OPEN
    When Continue button clicked
    And Selendroid info popup closed
    And Input sendkeys "TestQA"
    And Display Text View
    And Displays a Toast
    And Displays popup window button click
    And Press to throw unhandled exception

