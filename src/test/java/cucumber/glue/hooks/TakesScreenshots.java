package cucumber.glue.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

public class TakesScreenshots {

    @Autowired
    private WebDriverManager webDriverManager;

    @After
    public void takesScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) webDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException webDriverException) {
                System.err.println(webDriverException.getMessage());
            } catch (ClassCastException classCastException) {
                classCastException.printStackTrace();
            }
        }
    }
}
