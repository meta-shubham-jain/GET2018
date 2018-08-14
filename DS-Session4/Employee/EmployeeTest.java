import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
    EmployeeCollection employee = new EmployeeCollection();

    @Before
    public void init() {
        employee.addEmployeeInList(1, "Shubham Jain", "lucknow");
        employee.addEmployeeInList(2, "Ravi", "rajasthan");
        employee.addEmployeeInList(3, "Rahul", "goa");
        employee.addEmployeeInList(4, "Mohit", "delhi");
        employee.addEmployeeInList(5, "Zakir", "kanpur");
    }

    @Test
    public void testAddEmployee() {
        assertTrue(employee.addEmployeeInList(10, "Shyam", "Punjab"));
        assertTrue(employee.addEmployeeInList(8, "Mohit", "delhi"));
    }

    @Test
    public void testAddEmployee2() {
        // Adding employee with the key already allocated to some other employee
        assertFalse(employee.addEmployeeInList(1, "Shyam", "Punjab"));
        assertFalse(employee.addEmployeeInList(2, "Mohit", "delhi"));
    }

    @Test
    public void testSortOnId() {
        List<Employee> sortedEmployeeList = employee.sortNaturalOrder();
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1, "Shubham Jain", "lucknow"));
        employeeList.add(new Employee(2, "Ravi", "rajasthan"));
        employeeList.add(new Employee(3, "Rahul", "goa"));
        employeeList.add(new Employee(4, "Mohit", "delhi"));
        employeeList.add(new Employee(5, "Zakir", "kanpur"));
        for (int i = 0; i < sortedEmployeeList.size(); i++) {
            assertEquals(employeeList.get(i).getEmployeeId(),
                    sortedEmployeeList.get(i).getEmployeeId());
        }
    }

    @Test
    public void testSortOnName() {
        List<Employee> sortedEmployeeList = employee.sortByName();
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(4, "Mohit", "delhi"));
        employeeList.add(new Employee(3, "Rahul", "goa"));
        employeeList.add(new Employee(2, "Ravi", "rajasthan"));
        employeeList.add(new Employee(1, "Shubham Jain", "lucknow"));
        employeeList.add(new Employee(5, "Zakir", "kanpur"));
        for (int i = 0; i < sortedEmployeeList.size(); i++) {
            assertEquals(employeeList.get(i).getName(),
                    sortedEmployeeList.get(i).getName());
        }
    }

    @Test
    public void testNullPointerException() {
        try {
            employee.addEmployeeInList(15, null, "Punjab");
        } catch (NullPointerException ex) {
            assertEquals("Name or Address can't be null", ex.getMessage());
        }
    }
}