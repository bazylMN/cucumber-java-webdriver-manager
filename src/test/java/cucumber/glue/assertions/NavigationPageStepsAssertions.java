package cucumber.glue.assertions;

import org.junit.Assert;
import org.springframework.stereotype.Component;

@Component
public class NavigationPageStepsAssertions {

    public void assertPageIsCorrect(String currentPage, String name) {
        Assert.assertTrue(currentPage.contains(name));
    }
}
