@settingLocalization-feature
Feature: Google maps – localization

  Scenario Outline: As a user, I want to find a particular location
    Given Site maps.google.pl is opened
    When I enter "<localization>"
    Then I should see  "<localization>"  on map
    Examples:
      | localization |
      |Kalifornia    |
      |Nowy Jork     |
      |Tokio         |

