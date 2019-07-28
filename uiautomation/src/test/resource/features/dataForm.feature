Feature: Data Form
	User should be able to insert data using form
	
Scenario: Mandatory field are marked properly
	Given User is on the login page
	And User is logged in
	When User visits the form
	Then User can see all mandatory field are marked with * and Bold

Scenario: Save button in the form is disabled by default
	Given User is on the login page
	And User is logged in
	When User visits the form
	Then User will find the save button disabled

Scenario: User try to save data without filling out all mandatory field
	Given User is on the login page
	And User is logged in
	When User visits the form
	And User fill in all mandatory field except Manufacture
	| Title | First_Name | Last_Name | Age | Manufacture |
    | test1 | John       | Doe       |  28 |             |
	Then User will find the save button disabled
    
Scenario: User try to save data after filling out all mandatory field
	Given User is on the login page
	And User is logged in
	When User visits the form
	And User fill in all mandatory field
	| Title | First_Name | Last_Name | Age | Manufacture |
    | test1 | John       | Doe       |  28 | Audi        |
	And User can click on save button
	Then Inserted info will appear in the table