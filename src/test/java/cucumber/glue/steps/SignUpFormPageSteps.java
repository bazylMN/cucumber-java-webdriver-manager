package cucumber.glue.steps;

import cucumber.api.java8.En;
import cucumber.glue.dataTableMapping.SignUpFormDataTableMapping;
import cucumber.glue.pageObjects.SignUpFormPageObjects;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpFormPageSteps implements En {

    @Autowired
    private SignUpFormPageObjects signUpFormPageObjects;
    @Autowired
    private SignUpFormDataTableMapping dataMap;

    public SignUpFormPageSteps() {
        When("^I fill form fields with data$", (DataTable fields) -> {
            dataMap.writeDataToMap(fields);
            signUpFormPageObjects.signUp(
                    dataMap.get().get("login").toString(),
                    dataMap.get().get("email").toString(),
                    dataMap.get().get("password").toString());
        });

        Then("^I should see form with filled fields$", () -> {
            assertThat(signUpFormPageObjects.shouldSeeLoginData()).isEqualTo(dataMap.get().get("login"));
            assertThat(signUpFormPageObjects.shouldSeeEmailData()).isEqualTo(dataMap.get().get("email"));
            assertThat(signUpFormPageObjects.shouldSeePasswordData()).isEqualTo(dataMap.get().get("password"));
        });
    }
}
