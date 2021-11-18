import java.util.Comparator;

public class EmployeesComparator implements Comparator<EmployeesClass> {

    @Override
    public int compare(EmployeesClass o1, EmployeesClass o2) {
        if (o1.getJobs_completed()<o2.getJobs_completed()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
