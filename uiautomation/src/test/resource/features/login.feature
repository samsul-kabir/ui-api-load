Feature: Login
	User should be able to login to the platform
	
Scenario: User should be able to login with valid credentials
	Given User is on the login page
	When User enter username "test"
	And User enter password "test"
	And Click on login button
	Then User can access the application

Scenario: User cannot access account with invalid credentials
	Given User is on the login page
	When User enter username "wrong"
	And User enter password "wrong"
	And Click on login button
	Then User will see error message