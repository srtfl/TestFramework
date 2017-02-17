Feature: Check basic functionality of journey planner is working

#Search for a journey
Scenario: If I enter valid From and To stations than I should be taken to results page
	Given I am on Plan A Journey page
	When I enter From "St. James's Park Underground Station" and To "Waterloo Underground Station" and click on Plan A Journey button
	Then I should see the journey planner results page