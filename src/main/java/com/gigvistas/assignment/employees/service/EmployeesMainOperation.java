package com.gigvistas.assignment.employees.service;

import com.gigvistas.assignment.employees.dto.EmployeeDto;
import com.gigvistas.assignment.employees.util.MyCustomException;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeesMainOperation {
    static String currentline;
    public static Logger logger = LogManager.getLogger("com.gigvistas.assignment.employees.service");
    public void mainOperation() throws IOException {
        logger.info("Enter the file : ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        logger.info("File Extension is : "+ FilenameUtils.getExtension(filename));
        List<EmployeeDto> user = userReadFile(filename);
        System.out.println(user);
        EmployeesOperations userOperations = new EmployeesOperations(user);
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            logger.info("1.Search the user record based on the UserCode.");
            logger.info("2.Search the record of who has completed maximum jobs.");
            logger.info("3.Print records in alphabetic order by name.");
            logger.info("4.Write the records in a diff file which prefers a remote job.");
            logger.info("5.Send email to support@gigvistas.com if there is an inactive member.");
            logger.info("6.Exiting from the process.");
            logger.info("Enter your choice: ");
            choice = scan.nextInt();
            logger.debug("User performed "+choice);
            switch (choice) {
                case 1:
                    logger.info("1.Search the user record based on the UserCode.");
                    logger.info("Enter the user code to search : ");
                    String userCode = sc.next();
                    userOperations.searchUserCodeOperation(userCode);
                    break;

                case 2:
                    logger.info("2.Search the record of who has completed maximum jobs.");
                    userOperations.searchMaxJobCompletion();
                    break;

                case 3:
                    logger.info("3.Print records in alphabetic order by name.");
                    userOperations.sortByAlphabeticOrder();
                    break;

                case 4:
                    logger.info("4.Write the records in a diff file which prefers a remote job.");
                    logger.info("Enter Preferred Location: ");
                    String location = sc.next();
                    userOperations.createFileConsistRemoteJobs(location);
                    break;
                case 5:
                    logger.info("5.Send email to support@gigvistas.com if there is an inactive member.");
                        userOperations.findInactiveUser();
                    break;
                default:
                    logger.info("Exiting from the process....");
                    break;
            }
        } while (choice < 6);
    }

    public List<EmployeeDto> userReadFile(String filename) throws IOException {
        List<EmployeeDto> user = new ArrayList<>();
        BufferedReader br = null;
        logger.debug("Read the records from the file");
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            logger.error("Error: file not found and entered file is " +e.getMessage());
            System.exit(0);
        }
        int count=1;
        while ((currentline = br.readLine()) != null ) {
            String[] column = currentline.split(",");
            if (column[0].equals("usercode")) {
                count++;
                continue;
            }
            try {
                if(column.length < 5 || column[4].isEmpty()) {
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 5th column ");
                }
                else if(column[0].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 1th column");
                }
                else if(column[1].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 2th column");
                }
                else if(column[2].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 3th column");
                }
                else if(column[3].isEmpty()){
                    throw new MyCustomException("Not enough data at " +count+ "rd row & 4th column");
                }
                else {
                    String usercode = column[0];
                    String name = column[1];
                    int jobs_completed = Integer.parseInt(column[2]);
                    String preffered_location = column[3];
                    Boolean inactive = Boolean.parseBoolean(column[4]);
                    user.add(new EmployeeDto(usercode, name, jobs_completed, preffered_location, inactive));
                }
            }
            catch (Exception e){
                logger.error(" Error while reading the file. "+e.getMessage());
            }
            count++;
        }
        return user;
    }
}
