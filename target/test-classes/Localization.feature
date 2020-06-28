@settingLocalization-feature
Feature: Google maps – localization

  Scenario Outline: As a user, I want to find a particular location
    Given I am on maps.google.pl
    When I enter "<localization>" in 'Search Google Maps' field
    Then I should see  "<localization>"  on map
    Examples:
      | localization |
      |Kalifornia    |
      |Polska        |
      |Katowice      |

