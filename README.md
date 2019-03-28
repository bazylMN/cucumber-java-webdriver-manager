# Cucumber-java-webdriver-manager template
#### with Cucumber-java, Cucumber Spring, Selenide library and webdriver manager (Selenium WebDriver) for:
* ##### chrome
* ##### firefox
* ##### chrome headless
* ##### iexplorer

### Prerequisites
* gradle
* Cucumber for Java plugin for IntelliJ
* Gherkin for IntelliJ
* chromedriver.exe (put it into project root)- chrome is set as default browser
* geckodriver.exe (put it into project root)- is needed for newer FF versions
* IEDriverServer.exe (put it into project root)

### Initial
* clone repository
* open build.gradle file in IDE (IntelliJ)
* import dependencies with gradle

### Customise Cucumber tests
* add your .feature files with scenarios
* create custom steps class / steps classes with @Autowired annotations for page objects class / classes
* generate steps- in .feature file press 'alt+enter' shortcut and choose 'Create step definition' option, choose created steps class / steps classes to paste steps
* create custom page objects classes with methods and with @Component and @Autowired annotations for webdriver manager
* create assertions classes with methods and @Component annotation
* delete example .feature files, steps classes, page objects classes and assertion classes

### How to use Selenide
If there is a need to use Selenide to find elements or take action, simply add one line in page object method:
```
WebDriverRunner.setWebDriver(your initialized driver);
```

Method in template, which is using Selenide to find element might look like below:
```
    @Autowired
    private WebDriverManager webDriverManager;

    private static final String JAM_MENU = ".Header-nav-item[href*=jam]";

    public void clickJamMenu(){
        WebDriverRunner.setWebDriver(webDriverManager.getDriver());
        $(JAM_MENU).click();
    }

```
### How to run tests:
#### With gradle command:

###### To run Cucumber tests with custom runTests task and with default browser, type:
```
 runTests
```

###### To run Cucumber tests with custom runTests task and with chosen browser, type:
``` 
-Dbrowser=chrome runTests
```
```
-Dbrowser=firefox runTests
```
```
-Dbrowser=chromeHeadless runTests
```
```
-Dbrowser=iexplorer runTests
```

###### To run Cucumber tests with default browser, type:
```
clean test
```

###### To run Cucumber tests with chosen browser, type:
```
clean -Dbrowser=chrome test
```
```
clean -Dbrowser=firefox test
```
```
clean -Dbrowser=chromeHeadless test
```
```
clean -Dbrowser=iexplorer test
```

#### With IDE (JUnit):
```
run CucumberRunner class
```
```
or run .feature file / directory with .feature files / scenario in .feature file
```

### Reports and screenshots
Reports are placed in 'target' directory, including screenshots of failed scenarios.
To run report in browser, open 'target\html\index.html' file and choose browser.

### Gradle custom tasks
* runTests
* deleteCucumberReports
