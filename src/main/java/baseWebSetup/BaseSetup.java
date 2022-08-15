package baseWebSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import app.utils.TestData;

import java.io.IOException;
import java.time.Duration;

@Slf4j
public class BaseSetup {

    protected  WebDriver driver;
    static TestData testData;

    @BeforeMethod (alwaysRun = true)
    public void beforeMethod() throws IOException {
        testData = new TestData();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().setHeadless(false));
        driver.manage().window().setSize(new Dimension(1600, 1100));
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testData.properties.getProperty("baseUrl"));
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }

}
