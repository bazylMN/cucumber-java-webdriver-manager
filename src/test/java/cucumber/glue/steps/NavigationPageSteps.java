package cucumber.glue.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import cucumber.glue.assertions.NavigationPageStepsAssertions;
import cucumber.glue.pageObjects.NavigationPageObjects;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationPageSteps implements En {

    @Autowired
    private NavigationPageObjects navigationPageObjects;
    @Autowired
    private NavigationPageStepsAssertions assertions;

    @Given("I go to {string} page")
    public void iGoToPage(String urlName){
        navigationPageObjects.getPage(urlName);
   }

    @Then("I should be on {string} page")
    public void iShouldBeOnPage(String name){
        String currentPage = navigationPageObjects.getCurrentUrl();
        assertions.assertPageIsCorrect(currentPage, name);
    }
}
