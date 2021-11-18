import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.util.*;

public class EmployeesOperations {
    Scanner sc = new Scanner(System.in);
    String filename;
    List<EmployeesClass> users = new ArrayList<>();
    public static final Logger logger = LogManager.getLogger(EmployeesOperations.class);
    public EmployeesOperations(List<EmployeesClass> user) {
        this.users = user;
    }

    public void searchUserCodeOperation(){
        new Log();
        boolean found = false;
        System.out.println("Enter the user code");
        String userCode = sc.next();
        logger.info("UserCode entered is " +userCode);
        for (EmployeesClass user : users) {
            if (userCode.equals(user.getUsercode())) {
                System.out.println(user.toString());
                found = true;
            }
        }
        if(!found){
            System.out.println("User not found");
        }
    }


    public void sortByAlphabeticOrder() {
        Collections.sort(users);
        System.out.println("After sorting : ");
        logger.info("Sorting Performance");
        System.out.println(users);
    }

    public void searchMaxJobCompletion(){
        EmployeesComparator userComparator = new EmployeesComparator();
        logger.info("Searching the max job Performance");
        System.out.println(Collections.max(users, userComparator));
    }

    public void createFileConsistRemoteJobs(){
        try{
            System.out.println("Enter Preferred Location : ");
            String location = sc.next();
            logger.info("Preferred location entered is " +location);
            System.out.println("Enter the file name to store the data : ");
            String filename3 = sc.next();
            logger.info("Name of the entered is " +filename3);
            FileWriter writer = new FileWriter(filename3);
            for (EmployeesClass u2 : users) {
                if (location.equals(u2.getPreffered_location())) {
                    System.out.println(u2.toString());
                    writer.append(u2.addData());
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
