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

Feature: PC Builder Create Account

 Background: 
	Given a User is on the Home page

  Scenario: A User can create a new account
    When A User types in a new "<username>" and "<password>" into the login form and clicks create account button
    Then The User should receive a success message
    And Get redirected to their user page 

    Examples: 
      |username	| password	|
      |anything	|	pass123		|
