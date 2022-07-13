#Author: kevin962@revature.net
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
Feature: Part Search

	Background:
		Given A Visitor is on the Part Search page
 
  Scenario Outline: A Visitor wants to view parts of a certain type with price constraints

    When A Visitor selects "<parttype>" from the selection dropdown
    And A Visitor enters a bottom-limit cash value into "<pricefloor>"
    And A Visitor enters a top-limit cash value into "<priceceiling>"
    And A Visitor clicks the PartSearchButton
    Then A relevant table of results should populate the page
    
    Examples:
    |parttype		|pricefloor	|priceceiling	|
    |All				|						|							|
    |Motherboard|100				|							|
    |CPU				|						|							|
    |RAM				|						|150					|
    |Case				|						|							|
    |Storage		|50					|150					|
    |PSU				|						|							|


