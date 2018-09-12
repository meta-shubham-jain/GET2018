package com.servelets;

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

/**
 * This servlet class is for update details of employee
 * 
 * @author Shubham Jain
 *
 */
public class UpdateDetails extends HttpServlet {

    /**
     * This method fetch the details from url of the browser
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        try (Connection connection = (Connection) ConnectionToDB
                .getConnection();) {
            String query = Queries.getUpdateEmployeeDetailsQuery();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            PreparedStatement statement = connection.prepareStatement(query);
            int id = Integer.parseInt(request.getParameter("employeeid"));
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            res.next();
            String firstName = res.getString("first_name");
            String lastName = res.getString("last_name");
            String email = res.getString("email");
            int age = res.getInt("age");
            Employee employee = new Employee(id, firstName, lastName, email,
                    age);
            out.println("<html><head><script type='text/javascript' src='validation.js'></script></head><body>");
            out.println("<form action='Update' name='adddetailsform' method='get' onsubmit='return validate()'>");
            out.println("<div><span>First Name</span><input type='text' name ='first_name' value='"
                    + employee.getFirstName() + "' required/></div>");
            out.println("<div><span>Last Name</span><input type='text' name ='last_name' value='"
                    + employee.getLastName() + "' required/></div>");
            out.println("<div><span>Email</span><input type='text' name ='email' value='"
                    + employee.getEmail() + "' readonly required/></div>");
            out.println("<div><span>Age</span><input type='number' name ='age' value='"
                    + employee.getAge() + "' required/></div>");
            out.println("<div><input type='hidden' name='employeeid' value='"
                    + employee.getId()
                    + "'><input type='submit' name='Update' value='Update'></div>");
            out.println("</form>");
            out.println("</body></html>");
            out.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}