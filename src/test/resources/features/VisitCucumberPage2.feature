Feature: As a user i want to visit another cucumber pages

Scenario: Visit cucumber pages
  Given I go to "https://cucumber.io/blog" page
    Then I should be on "https://cucumber.io/blog" page
    When I go to "https://cucumber.io/events" page
    Then I should be on "https://cucumber.io/events" page


Scenario: Visit another cucumber pages
  Given I go to "https://docs.cucumber.io/" page
    Then I should be on "https://docs.cucumber.io/" page
    When I go to "https://docs.cucumber.io/cucumber/" page
    Then I should be on "https://docs.cucumber.io/cucumber/" page
