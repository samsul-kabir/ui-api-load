Feature: User List Service 
	This will return list of all the users

Scenario: Verifying list of Users 
	Given I have baseUrl for rest service 
	When I execute service for user list 
	Then I validate statuscode 
	And I verify all id inside data is not NULL 
	And I also validate all url in avatar has success statuscode 
	
Scenario Outline: Single user 
	Given I have baseUrl for rest service 
	When I execute service for single user with <id> 
	Then Single user response has correct <statuscode> 
	Examples: 
		| id | statuscode |
		| 2  | 200        |
		| 23 | 404        |
		