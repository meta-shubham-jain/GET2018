import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeCollection {
    List<Employee> employeeList = new ArrayList<>();
    Set<Integer> idSet = new HashSet<>();

    boolean addEmployeeInList(int employeeId, String name, String address) {
        Employee employee = new Employee(employeeId, name, address);
        if (idSet.add(employeeId)) {
            employeeList.add(new Employee(employeeId, name, address));
            return true;
        }
        return false;
    }

    /**
     * Sort Employee List according to Employee Id
     * @return
     */
    List sortNaturalOrder() {
        Collections.sort(employeeList, compareId);
        return employeeList;
    }

    /**
     * Sort Employee List according to Employee Name 
     * @return
     */
    List sortByName() {
        Collections.sort(employeeList, compareName);
        return employeeList;
    }

    /**
     * Comparator to sort list according to name of employee
     */
    Comparator<Employee> compareId = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getEmployeeId() - emp2.getEmployeeId();
        }
    };

    /**
     * Comparator to sort list according to name of employee
     */
    Comparator<Employee> compareName = new Comparator<Employee>() {
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getName().compareTo(emp2.getName());
        }
    };
}