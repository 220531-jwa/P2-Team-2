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

Feature: PC Builder Create Build
 
 Background:
 	Given A User is logged in 
 	And on the Create Build Page
 
  Scenario: A User can Create New Build button
 
 	When A User click the CPU Selector
 	Then The User should be able to pick a CPU
 	
 	When A User click the Motherboard Selector
 	Then The User should be able to pick a motherboard
 	
 	When A User click the RAM Selector
 	Then The User should be able to pick a RAM
 	
 	When A User click the Storage Selector
 	Then The User should be able to pick a Storage
 	
 	When A User click the Case Selector
 	Then The User should be able to pick a Case
 	
 	When A User click the PowerSupply Selector
 	Then The User should be able to pick a PowerSupply
 

  
