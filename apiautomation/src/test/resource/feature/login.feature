Feature: Login 
	User will be able to login

Scenario Outline: Login with valid and invalid credential 
	Given I have baseUrl for rest service 
	When User submit login reguest with credentials <email> and <password> 
	Then It returns correct <statuscode> 
	And Response has token if succeed 
	Examples: 
		| email          | password       | statuscode |
		| "peter@klaven" | "cityslicka"   | 200        |
		| ""             | "cityslicka"   | 400        |
		| "peter@klaven" | ""             | 400        |
		| ""             | ""             | 400        |
		| "hello"        | "world"        | 200        |