package com.gigvistas.assignment.employees;

import com.gigvistas.assignment.employees.service.EmployeesMainOperation;
import com.gigvistas.assignment.employees.util.MyCustomException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class MainApplication {

	public static Logger logger = LogManager.getLogger(MainApplication.class);
	public static void main(String[] args) throws IOException{
		try {
			EmployeesMainOperation employeesMainOperation = new EmployeesMainOperation();
			employeesMainOperation.mainOperation();
		}
		catch (Exception e){
			logger.error("Something went wrong");
			System.out.println("Error: " + e.getMessage());
		}
	}
}
