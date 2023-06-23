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
@register
Feature: Register user prevent
  I want to use this feature to Register prevent apk

  @register
  Scenario Outline: Register user
    Given User launch app for register
    When User must be showing splash screen define <description> and click button skip and click button sign up
    And User fill <username>,<email>,<password>,<confirm_password> and flag <status>
    Then User verify register feature condition <status> must be expected

    Examples: 
      | username | email               | password   | confirm_password | description                                                     | status   |  
      |          |                     |            |                  | Register redirect to otp page with java faker                   | positive |  
      | qaeng    | haha@test           | password12 | password12       | Register with field email invalid format                        | negative |  
      | qaeng    | baronqoro@gmail.com |            | password         | Register email already exist                                    | failed   |  
      | qaeng    | qaeng@email.com     | password   | hahaha           | Register with ulangi kata sandi not match with kata sandi field | negative |  
      |          |                     |            |                  | register with field all empty                                   | negative |  
