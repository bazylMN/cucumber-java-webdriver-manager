package cucumber.glue;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"cucumber.glue.hooks", "cucumber.glue.steps", "com.foreach.cuke"},
        features="src/test/resources/features",
        plugin={"pretty", "html:target/html"},
        monochrome=true)
@ContextConfiguration
@ComponentScan("classpath:cucumber.glue")
public class CucumberRunner {
}
