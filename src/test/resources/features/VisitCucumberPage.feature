Feature: As a user i want to visit cucumber pages

#Scenario: Visit cucumber pages
#  Given I go to https://cucumber.io/ page
#    Then I should be on https://cucumber.io/ page
#    When I click jam on menu
#    Then I should be on https://cucumber.io/jam page
#    When I go to https://cucumber.io/blog page
#      And I click jam on subpage
#    Then I should be on https://cucumber.io/jam page


  Scenario: Try to sign up for GitHub
    Given I go to https://github.com/ page
    When I fill form fields with data
      |login    |loginfirst     |
      |email    |email@first.pl |
      |password |first123       |
    Then I should see form with filled fields
