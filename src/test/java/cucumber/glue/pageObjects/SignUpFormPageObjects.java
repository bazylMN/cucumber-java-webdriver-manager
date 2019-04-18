package cucumber.glue.pageObjects;

import cucumber.glue.customAnnotations.PageObject;
import cucumber.glue.hooks.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class SignUpFormPageObjects {

    @Autowired
    private WebDriverManager webDriverManager;

    private static final String USER_LOGIN = "user[login]";
    private static final String USER_EMAIL = "user[email]";
    private static final String USER_PASSWORD = "user[password]";

    private static final String USER_INPUT = "[name^='user[']";
    private static final String USER_INPUT_ATTRIBUTE_NAME = "name";



    public void signUp(String login, String email, String password) {
        /**
         * Standard way to send keys:
         *         webDriverManager.getDriver().findElement(By.id(USER_LOGIN)).sendKeys(login);
         *         webDriverManager.getDriver().findElement(By.id(USER_EMAIL)).sendKeys(email);
         *         webDriverManager.getDriver().findElement(By.id(USER_PASSWORD)).sendKeys(password);
         */

        /**
         * lamdbda-way to send keys (imagine there is no id for inputs):
         */
        sendKeysForInputWithAttributeName("login", login);
        sendKeysForInputWithAttributeName("email", email);
        sendKeysForInputWithAttributeName("password", password);
    }

    public String shouldSeeLoginData() {
        return javaScriptGetData(USER_LOGIN);
    }

    public String shouldSeeEmailData() {
        return javaScriptGetData(USER_EMAIL);
    }

    public String shouldSeePasswordData() {
        return javaScriptGetData(USER_PASSWORD);
    }

    /**
     * Selenide way to use lambda expression:
     *
     *         $$(By.cssSelector(USER_INPUT))
     *                 .stream()
     *                 .filter(elem->elem.getAttribute(USER_INPUT_ATTRIBUTE_NAME).contains(partValueName))
     *                 .findFirst()
     *                 .get()
     *                 .sendKeys(keyToSend);
     */
    private void sendKeysForInputWithAttributeName(String partValueName, String keyToSend){
        webDriverManager.getDriver().findElements(By.cssSelector(USER_INPUT))
                .stream()
                .filter(elem->elem.getAttribute(USER_INPUT_ATTRIBUTE_NAME).contains(partValueName))
                .findFirst()
                .get()
                .sendKeys(keyToSend);
    }

    /**
     * Selenide way to run javaScript code:
     *
     * return executeJavaScript("return document.getElementById('"+ data +"').value");
     */
    private String javaScriptGetData(String data){
        JavascriptExecutor js=(JavascriptExecutor)webDriverManager.getDriver();
        return (String)js.executeScript("return document.getElementById('"+ data +"').value");
    }
}
