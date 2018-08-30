package com.servelets;

/**
 * This servlet class is for show details of employees
 * 
 * @author Shubham Jain
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ConnectionToDB;
import com.dao.Employee;
import com.dao.Queries;
import com.mysql.jdbc.Connection;

public class ShowEmployeeDetails extends HttpServlet {

    /**
     * This method fetch the details from url of the browser
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        try (Connection connection = (Connection) ConnectionToDB
                .getConnection();) {
            String query = Queries.getShowEmployeeDetailsQuery();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            while (res.next()) {
                int employeeId = res.getInt("employee_id");
                String firstName = res.getString("first_name");
                String lastName = res.getString("last_name");
                String email = res.getString("email");
                int age = res.getInt("age");
                Employee employee = new Employee(employeeId, firstName,
                        lastName, email, age);
                listOfEmployee.add(employee);
            }
            out.println("<html><body>");
            out.println("<h1>Employee Details</h1>");
            out.println("<table border=1 width=20% height=20%>");
            out.println("<tr><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th><th>AGE</th><th>Update</th><tr>");
            for (Employee employee : listOfEmployee) {
                out.println("<tr><td>" + employee.getFirstName() + "</td><td>"
                        + employee.getLastName() + "</td><td>"
                        + employee.getEmail() + "</td><td>" + employee.getAge()
                        + "</td>");
                out.println("<td><form action='UpdateDetails'>");
                out.println("<input type='hidden' name='employeeid' value='"
                        + employee.getId() + "'/>");
                out.println("<input type='submit' value='Update'/>");
                out.print("</form></td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            out.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}