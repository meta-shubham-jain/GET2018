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
 * This servlet class is for search details of employee
 * 
 * @author Shubham Jain
 *
 */
public class SearchEmployee extends HttpServlet {

    /**
     * This method fetch the details from url of the browser
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = ConnectionToDB.getConnection();) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String query = Queries.getSearchEmployeeQuery();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet res = statement.executeQuery();
            List<Employee> listOfEmployee = new ArrayList<Employee>();
            while (res.next()) {
                firstName = res.getString("first_name");
                lastName = res.getString("last_name");
                String email = res.getString("email");
                int age = res.getInt("age");
                Employee employee = new Employee(0, firstName, lastName, email,
                        age);
                listOfEmployee.add(employee);
            }
            out.println("<html><body>");
            out.println("<h1>Employee Details</h1>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th><th>AGE</th><tr>");
            for (Employee employee : listOfEmployee) {
                out.println("<tr><td>" + employee.getFirstName() + "</td><td>"
                        + employee.getLastName() + "</td><td>"
                        + employee.getEmail() + "</td><td>" + employee.getAge()
                        + "</td>");
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