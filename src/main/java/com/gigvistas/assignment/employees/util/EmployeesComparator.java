package com.gigvistas.assignment.employees.util;

import com.gigvistas.assignment.employees.dto.EmployeeDto;

import java.util.Comparator;

public class EmployeesComparator implements Comparator<EmployeeDto> {

    @Override
    public int compare(EmployeeDto o1, EmployeeDto o2) {
        if (o1.getJobs_completed()<o2.getJobs_completed()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
