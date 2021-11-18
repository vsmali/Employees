import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReadFile {
    String filename;
    String currentline;

    public DataReadFile(String filename) {
        this.filename = filename;
    }
    public List<EmployeesClass> userop(){
        List<EmployeesClass> user = new ArrayList<>();
        try {
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
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
            e.printStackTrace();
        }
        return user;
    }
}
