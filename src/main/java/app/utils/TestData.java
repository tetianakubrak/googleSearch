package app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {

    public Properties properties = new Properties();
    File file = new File("src/main/resources/config.properties");

    public TestData() throws IOException {
        FileInputStream fileInput = new FileInputStream(file);
        properties.load(fileInput);
        fileInput.close();
    }
}
