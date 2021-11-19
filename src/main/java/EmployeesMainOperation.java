import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class EmployeesMainOperation {
    public static final Logger logger = LogManager.getLogger(EmployeesMainOperation.class);
    public void mainOperation(){
        new Log();
        System.out.println("Enter the file : ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        logger.info("Reading the file from the user");
        logger.info("User Performance starts");
        DataReadFile uo = new DataReadFile(filename);
        List<EmployeesClass> u1 = uo.userop();

        EmployeesOperations userOperations = new EmployeesOperations(u1);
        EmployeesMainOperation userApplication = new EmployeesMainOperation();
        userApplication.checkFileFormatOperation(filename);
        int choice;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1.Search the user record based on the UserCode.");
            System.out.println("2.Search the record of who has completed maximum jobs.");
            System.out.println("3.Print records in alphabetic order by name.");
            System.out.println("4.Write the records in a diff file which prefers a remote job.");
            System.out.println("5.Send email to support@gigvistas.com if there is an inactive member.");
            System.out.println("6.Exiting from the process.");
            System.out.println("----------------------------------------");
            System.out.println("Enter your choice: ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            logger.info("User performed "+choice);
            switch (choice) {
                case 1:
                    System.out.println("1.Search the user record based on the UserCode.");
                    userOperations.searchUserCodeOperation();
                    break;

                case 2:
                    System.out.println("2.Search the record of who has completed maximum jobs.");
                    userOperations.searchMaxJobCompletion();
                    break;

                case 3:
                    System.out.println("3.Print records in alphabetic order by name.");
                    userOperations.sortByAlphabeticOrder();
                    break;

                case 4:
                    System.out.println("4.Write the records in a diff file which prefers a remote job.");
                    userOperations.createFileConsistRemoteJobs();
                    break;

                case 5:
                    System.out.println("5.Send email to support@gigvistas.com if there is an inactive member.");
                        userOperations.findInactiveUser();
                    break;

                default:
                    System.out.println("Exiting from the process....");
                    break;
            }
        } while (choice != 6);
        logger.info("User Performance ends");
    }

    public  String checkFileFormatOperation(String filename){
        System.out.println("File Exist and File Extension is : "+ FilenameUtils.getExtension(filename));
        return filename;
    }
}
