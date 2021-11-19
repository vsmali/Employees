import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReadFile {
    String filename;
    String currentline;
    public static final Logger logger = LogManager.getLogger(MainApplication.class);
    public DataReadFile(String filename) {
        this.filename = filename;
    }
    public List<EmployeesClass> userop(){
        List<EmployeesClass> user = new ArrayList<>();
        try {
            new Log();
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            logger.info("Reading the employee file "+filename);
            while ((currentline = br2.readLine() )!= null){
                String[] deatailed = currentline.split(",");
                String usercode = deatailed[0];
                String name = deatailed[1];
                int jobs_completed = Integer.parseInt(deatailed[2]);
                String preffered_location = deatailed[3];
                boolean inactive = Boolean.parseBoolean(deatailed[4]);
                user.add(new EmployeesClass(usercode,name,jobs_completed,preffered_location,inactive));
            }
        }
        catch (Exception e ){
            logger.error("Something went wrong");
            e.printStackTrace();
        }
        return user;
    }
}
