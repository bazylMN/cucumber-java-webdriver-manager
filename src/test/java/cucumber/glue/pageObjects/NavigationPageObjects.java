package cucumber.glue.pageObjects;

import cucumber.glue.hooks.WebDriverManager;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class NavigationPageObjects {

    @Autowired
    private WebDriverManager webDriverManager;

    public void getPage(String url) {
        webDriverManager.getDriver().navigate().to(url);
    }

    private static final String JAM_MENU = ".Header-nav-item[href*=jam]";
    private static final String JAM_MENU_SUBPAGE = ".header-nav [href*=jam]";

    public String getCurrentUrl() {
        return webDriverManager.getDriver().getCurrentUrl();
    }

    /**
     * Using Selenide driver
     */
    public void clickJam() {
        $(JAM_MENU).click();
    }

    /**
     * Using Selenium driver
     */
    public void clickJamOnSubpage() {
        webDriverManager.getDriver().findElement(By.cssSelector(JAM_MENU_SUBPAGE)).click();
    }
}
