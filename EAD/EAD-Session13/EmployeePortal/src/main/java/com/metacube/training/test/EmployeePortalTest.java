package com.metacube.training.test;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.configuration.MvcWebApplicationInitializer;
import com.metacube.training.configuration.MvcWebConfig;
import com.metacube.training.models.Employee;
import com.metacube.training.services.EmployeeService;

@ContextConfiguration(classes = { MvcWebApplicationInitializer.class,
        MvcWebConfig.class })
@ActiveProfiles("test")
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmployeePortalTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeByEmail() {
        Employee employee = employeeService
                .getEmployeeByEmail("admin@gmail.com");
        assertEquals(20, employee.getEmpCode());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeService.getById(2);
        assertEquals(2, employee.getEmpCode());
    }

    @Test
    public void testGetListOfEmployees() {
        List<Employee> employeeList = employeeService.getAll();
        assertEquals(8, employeeList.size());
    }

    @Test
    public void testGetEmployeesByName() {
        List<Employee> employeeList = employeeService.getEmployeeByName(
                "Shubham", "Jain");
        assertEquals(2, employeeList.get(0).getEmpCode());
    }

    @Test
    public void testGetEmployeesByProjectId() {
        List<Employee> employeeList = employeeService.getEmployeesByProject(1);
        assertEquals(2, employeeList.size());
        assertEquals(25, employeeList.get(0).getEmpCode());
        assertEquals(2, employeeList.get(1).getEmpCode());
    }

    @Test
    public void testGetEmployeesBySkills() {
        List<Employee> employeeList = employeeService.getEmployeeBySkills(1);
        assertEquals(3, employeeList.size());
    }

    @Test
    public void testCheckCredentials() {
        assertEquals(com.metacube.training.Status.Status.OK,
                employeeService.checkValidCredentials("admin@gmail.com",
                        "123456"));
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setMiddleName("Kumar");
        employee.setLastName("Jain");
        employee.setEmail("rajqwe@gmail.com");
        employee.setEnabled(true);
        employee.setPrimaryContact("123456789");
        employee.setSkypeId("skype@gmail.com");
        employee.setSkills(new String[] { "1" });
        employee.setGender("M");
        Date now = new Date(0);
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        employee.setDob(sqlDate);
        employeeService.create(employee);
        List<Employee> employeeList = employeeService.getAll();
        assertEquals(9, employeeList.size());
    }

    @Test
    public void testDeleteEmployee() {
        employeeService.delete(2);
        List<Employee> employeeList = employeeService.getAll();
        assertEquals(7, employeeList.size());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Raj");
        employee.setMiddleName("Ku");
        employee.setLastName("Jain");
        employee.setEmail("rajqwe@gmail.com");
        employee.setEnabled(true);
        employee.setPrimaryContact("123456789");
        employee.setSkypeId("skype@gmail.com");
        employee.setSkills(new String[] { "1" });
        employee.setGender("M");
        Date now = new Date(0);
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        employee.setDob(sqlDate);
        employeeService.create(employee);
        List<Employee> employeeList = employeeService.getAll();
        assertEquals("Ku", employeeList.get(8).getMiddleName());
    }
}