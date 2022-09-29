package runners;

import utils.FileUtils;
import utils.PropertyUtils;

import java.io.IOException;
import java.util.Properties;

public class SandBox {

    public static void main(String[] args) throws IOException {
        String browser = PropertyUtils.getProperty("browser");

        System.out.println(browser);

        String file = FileUtils.readFileAsString("config/", "test.txt");

        System.out.println("FILE: " + file);

    }
}
