Test case wrote in Gherkin for Google Maps Website

Feature:  Find “<localization>”  
Scenario Outline: As a user, I want to find a particular location on a map
Given I am on https://www.google.pl/maps/
When I enter “<localization>” in “Search Google Maps” field
Then I should see  “<localization>” on map
Examples:
| localization|
|Kalifornia   |
|Polska       |
|Katowice     |
  

 
 
 
 



