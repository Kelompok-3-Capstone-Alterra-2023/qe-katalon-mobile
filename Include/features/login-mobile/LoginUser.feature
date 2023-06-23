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
@login
Feature: Login user prevent
  I want to use this feature to login prevent apk

  @login
  Scenario Outline: Login user
    Given User launch app
    When User must be showing splash screen define <description> and click button skip
    And User fill <username> and <password> and click button sign in
    Then User verify condition <status> must be expected

    Examples: 
      | username                 | password | description                                       | status   |
      | jasmine.nabila@email.com | check123 | Login with input not registered                   | failed   |
      | skydust80@gmail.com      | checkeck | Login with input valid email and invalid password | failed   |
      | qatesting@email.com      | password | Login with input valid email and valid password   | positive |
      |                          |          | Login with input no email and no password         | negative |
      |                          | password | Login with input empty email and valid password   | negative |
      |                          | check123 | Login with input empty email and invalid password | negative |
