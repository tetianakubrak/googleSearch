Selenium Webdriver project with set of regression tests for Google Search

Prerequisite to run the project
JDK
Maven


The project summery at a glance:

1. Project type: Maven project
2. Programming Language: Java
3. Automation tool: Selenium WebDriver
4. Testing Framework: TestNG
5. Method used for page object model: Page Object
6. Browser initiation: WebDriverManager
7. Maven compiler and test has been added as well in case user wants to run it as a maven test
8. All the page, webelement and steps  are available on project>src>main>java>app>pages
9. All the tests and test related initialisation & data are available on project>src>test>java

Before execution:
- Maven setup has been done with all the related dependencies, build and plugin data.
- Browser initiation method has been added into BaseTest class and browser keys are available in properties file.
- Browser window size, position has been set.


Test execution:
- testng.xml file has been created with GoogleSearchAnonymousUserTests class, from where tests can be executed.



