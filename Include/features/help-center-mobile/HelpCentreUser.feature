#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@help-center
Feature: Dashboard mobile
  I want to use this successfully loaded help centre

  @verify-help-centre
  Scenario: Verify has been loaded help centre
    Given User must be logged on dashboard prevent for feature help centre
    When User click icon hamburger and click option help centre
    Then User verify web view help centre prevent