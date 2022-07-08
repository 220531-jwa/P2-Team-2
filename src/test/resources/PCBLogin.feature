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

Feature: PC Builder Login

	Background:
		Given A User is on the Home page

  Scenario Outline: A User can login using their credentials
    When A User enters their "<username>" and "<password>" in the login form and click the login button
    Then The User should be on their account page

    Examples: 
      | username  | password	|
      | kpro			|   pass		|
      | elle	 		|		pass		|
      |	mfar			|		pass		|
      | jmor			|		pass		|