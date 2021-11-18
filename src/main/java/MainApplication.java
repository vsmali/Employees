import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class MainApplication {

	public static final Logger logger = LogManager.getLogger(MainApplication.class);
	public static void main(String[] args) throws IOException{
		try {
			new Log();
			logger.info("Employee Application Starts");
			EmployeesMainOperation employeesMainOperation = new EmployeesMainOperation();
			employeesMainOperation.mainOperation();
			logger.debug("Employee Application Ends");
		}
		catch (Exception e){
			logger.error("the error message");
			e.printStackTrace();
		}
	}
}
