package HBO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HBOProperties {
    Properties objectRepository = new Properties();
    Properties config = new Properties();




    public HBOProperties() throws IOException {
        FileInputStream fis1 = new FileInputStream( System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjectRepository.properties");
        FileInputStream fis2 = new FileInputStream( System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        objectRepository.load(fis1);
        config.load(fis2);

    }


}
