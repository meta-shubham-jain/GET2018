package com.metacube.training.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.metacube.training.configuration.MvcWebApplicationInitializer;
import com.metacube.training.configuration.MvcWebConfig;
import com.metacube.training.controller.AdminController;
import com.metacube.training.models.Employee;
import com.metacube.training.services.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MvcWebApplicationInitializer.class,
        MvcWebConfig.class })
@WebAppConfiguration
public class AdminControllerTest  {

    private MockMvc mockMvc;

    @Autowired
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    private AdminController adminController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testEmployeeByName() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Shubham");
        employee.setMiddleName("kumar");
        employee.setLastName("Jain");
        java.sql.Date sqlDate = new java.sql.Date(2018 - 10 - 05);
        employee.setDob(sqlDate);
        employee.setEmail("employee@gmail.com");
        employee.setEmpCode(2);
        employee.setEnabled(true);
        employee.setGender("M");
        employee.setPassword("123456");
        employee.setPrimaryContact("123456789");
        employee.setSkypeId("asd@skype.com");
        employee.setSkills(null);

        Mockito.when(employeeService.getEmployeeByName("Shubham", "Jain")).thenReturn(Arrays.asList(employee));
        mockMvc.perform(get("/admin/searchEmployee")).andExpect(status().isOk());
    }
}
