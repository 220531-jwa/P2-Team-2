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

Feature: User Account Features

	Background:
		Given A User is logged in
#		And A User is on their UserPage	
    
  Scenario: Create a New Build
    When They click they click the CreateBuild button
    Then They are redirected to the CreateBuild Page
    
	Scenario: Edit a Build
    When They click they click the EditBuild button
    Then They are redirected to the EditBuild Page
    
#	Scenario: View Created Build(s)
    #When They click they click the CompletedBuilds button
    #Then They are redirected to the CompletedBuilds Page
    
	Scenario: Search for Parts
    When They click they click the PartSearch button
    Then They are redirected to the PartSearch Page