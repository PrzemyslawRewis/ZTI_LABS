package com.example.zti_zad1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SaveToDatabase", value = "/SaveToDatabase")
public class SaveToDatabase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        Person person = new Person(firstName, lastName, city);
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/iylsvsgi";
            String username = "iylsvsgi";
            String password = "6wQghFtORNE3yov9XPHl_c6qJVQ3wTiu";
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO person (fname, lname, city) VALUES (?, ?, ?)");
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getCity());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            response.sendRedirect("/ZTI_zad1_war_exploded/mvc/addPersonFailure.jsp");
            return;
        }
        response.sendRedirect("/ZTI_zad1_war_exploded/mvc/addPersonSuccess.jsp");
    }
}
