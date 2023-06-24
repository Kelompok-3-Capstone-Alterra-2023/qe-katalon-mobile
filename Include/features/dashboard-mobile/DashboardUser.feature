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
@dashboard-mobile
Feature: Dashboard mobile
  I want to use this successfully expect to dashboard feature
  
  @search-bar-article
  Scenario Outline: Search article
    Given User click and set text <value> article
    And User click value search and include <description>
    Then User verify expected condition based on <status>

    Examples: 
      | value     | description                 | status  |
      | Peristiwa | Search article is found     | success |
      | Error     | Search article is not found | failed  |

  @view-list-doctor-details
  Scenario: Verify all navigate success go to consultation page until detail doctor
    Given User must be logged on dashboard prevent
    When User click button consultation
    And User choose doctor on list doctor page
    Then User verify details doctor successfully

  @all-navbar-success
  Scenario: Verify all navigation bar is clickable
    Given User click consultation history and verified
    And User click notification and verified
    Then User click profile and get profile data

  @article-detail-content-dashboard
  Scenario: Verify success clickable go to an article details content page
    Given User verify article list page
    Then User click article to see details verify article get content
