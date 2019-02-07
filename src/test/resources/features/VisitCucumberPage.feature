Feature: As a user i want to visit cucumber pages

Scenario: Visit cucumber pages
  Given I go to "https://cucumber.io/" page
    Then I should be on "https://cucumber.io/" page
    When I go to "https://cucumber.io/training" page
    Then I should be on "https://cucumber.io/training" page


Scenario: Visit another cucumber pages
  Given I go to "https://docs.cucumber.io/gherkin/" page
    Then I should be on "https://docs.cucumber.io/gherkin/" page
    When I go to "https://docs.cucumber.io/tools/related-tools/" page
    Then I should be on "https://docs.cucumber.io/tools/related-tools/" page
