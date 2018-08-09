import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeCollection {
    private List<Employee> employeeList = new ArrayList<>();
    private Set<Integer> idSet = new HashSet<>();

    boolean addEmployeeInList(int employeeId, String name, String address) {
        if (name == null || address == null) {
            throw new NullPointerException("Name or Address can't be null");
        }
        Employee employee = new Employee(employeeId, name, address);
        if (idSet.add(employeeId)) {
            employeeList.add(new Employee(employeeId, name, address));
            return true;
        }
        return false;
    }

    /**
     * Sort Employee List according to Employee Id
     * 
     * @return
     */
    List sortNaturalOrder() {
        List<Employee> sortbyIdList = new ArrayList<Employee>(employeeList);
        Collections.sort(sortbyIdList);
        return sortbyIdList;
    }

    /**
     * Sort Employee List according to Employee Name
     * 
     * @return
     */
    List sortByName() {
        List<Employee> sortByNameList = new ArrayList<Employee>(employeeList);
        Collections.sort(sortByNameList, compareName);
        return sortByNameList;
    }

    /**
     * Comparator to sort list according to name of employee
     */
    Comparator<Employee> compareName = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getName().compareTo(emp2.getName());
        }
    };
}