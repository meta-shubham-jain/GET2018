import static org.junit.Assert.*;

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
    } 
    
    @Test
    public void testAddEmployee() {
        assertTrue(employee.addEmployeeInList(5, "Shyam", "Punjab"));
        assertTrue(employee.addEmployeeInList(8, "Mohit", "delhi"));
        assertEquals(6,employee.employeeList.size());
    }
    
    @Test
    public void testAddEmployee2() {
        //Adding employee with the key already allocated to some other employee
        assertFalse(employee.addEmployeeInList(1, "Shyam", "Punjab"));
        assertFalse(employee.addEmployeeInList(2, "Mohit", "delhi"));
    }
    
    @Test
    public void testSortOnId() {
        List<Employee> employeeList = employee.sortNaturalOrder();
        assertEquals("Shubham Jain",employeeList.get(0).getName());
        assertEquals("Rahul",employeeList.get(2).getName());
    }
    
    @Test
    public void testSortOnName() {
        List<Employee> employeeList = employee.sortByName();
        assertEquals("Mohit",employeeList.get(0).getName());
        assertEquals("Rahul",employeeList.get(1).getName());
        assertEquals("Ravi",employeeList.get(2).getName());
    }
}