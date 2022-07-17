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

Feature: PC Builder Edit Build

Background:
 	Given A User is logs in to their account
 	And They click they click the EditBuild button to create a build
 	
 	Scenario: A User can Edit A Build
 	
 	When A User click the Motherboard Selector
 	Then The User should be able to pick a Motherboard
 	
 	When A User click the CPU Selector
 	Then The User should be able to pick a CPU
 	
 	When A User click the RAM Selector
 	Then The User should be able to pick a RAM
 	
 	When A User click the Storage Selector
 	Then The User should be able to pick a Storage
 	
 	When A User click the PowerSupply Selector
 	Then The User should be able to pick a PowerSupply
 	
 	When A User click the Case Selector
 	Then The User should be able to pick a Case
 
 #	When A User fills in the build name
 	When A User clicks on submit build
 	Then They are redirected back to their home page
 	And Their modified build is listed in the table