import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Log {
    private static final String log_application_properties = "D:\\Assignment\\Employees\\src\\main\\resources\\application.properties";
    private static Logger logger = null;
    public Log() {
        Properties property= new Properties();
        try {
            property.load(new FileInputStream(log_application_properties));
            PropertyConfigurator.configure(property);
        } catch (IOException e) {
            logger.error("the error message");
            e.printStackTrace();
        }
    }
}