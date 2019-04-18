package cucumber.glue.steps;

import cucumber.api.java8.En;
import cucumber.glue.assertions.NavigationPageStepsAssertions;
import cucumber.glue.pageObjects.NavigationPageObjects;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationPageSteps implements En {

    @Autowired
    private NavigationPageObjects navigationPageObjects;
    @Autowired
    private NavigationPageStepsAssertions assertions;

    public NavigationPageSteps(){
        Given("^I go to (.*?) page", (String urlName) -> {
            navigationPageObjects.getPage(urlName);
        });

        Then("^I should be on (.*?) page", (String name) -> {
            Assert.assertTrue(navigationPageObjects.getCurrentUrl().contains(name));
        });

        When("^I click jam on menu", () -> {
            navigationPageObjects.clickJam();
        });

        And("I click jam on subpage", () ->{
            navigationPageObjects.clickJamOnSubpage();
        });
    }
}
