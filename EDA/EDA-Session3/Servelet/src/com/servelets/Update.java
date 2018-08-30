package com.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class Update extends HttpServlet {

    /**
     * This method fetch the details from url of the browser
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = ConnectionToDB.getConnection();) {
            String query = Queries.getUpdateEmployeeQuery();
            PreparedStatement statement = connection.prepareStatement(query);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("employeeid"));
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            Employee employee = new Employee(id, firstName, lastName, email,
                    age);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getId());
            int result = statement.executeUpdate();
            if (result > 0) {
                out.println("Succesfully Details Updated");
            } else {
                out.println("Can't Update Details");
            }
            out.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}