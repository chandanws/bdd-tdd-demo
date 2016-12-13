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

Feature: Testing Post Fix evaluator
	We would use this to test our post fix evaluator
	
Scenario: Testing the evaluator with sum only
Given User enters "2 3 5 + +"
When User asks for result
Then result should be "10"

Scenario Outline: Testing the evaluator with complex expressions
Given User enters <expression>
When User asks for result
Then result should be <result>

Examples:
    | expression | result |
    | "3 4 5 + -" | "-6" |
    | "5 1 2 + 4 * + 3 -" | "14"  |
    | "5 2 3 ^ + 5 8 + " | "13"  |
    | "2 1 12 3 / - +" | "-1" |
    | "6 3 - 2 ^ 11 - " | "-2" | 
    | "2.3 4.5 +" | "6.8" | 
    
