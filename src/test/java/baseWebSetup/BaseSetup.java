package baseWebSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    protected static Properties envConfig;
    protected static WebDriver driver;

    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver","src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        InputStream configFile = new FileInputStream(System.getProperty("user.dir") + "src/main/resources/production.properties");

        envConfig = new Properties();
        envConfig.load(configFile);
    }

    @BeforeTest()
    public void loadBaseUrl(Method method){
        driver.get("baseUrl");
    }


}
