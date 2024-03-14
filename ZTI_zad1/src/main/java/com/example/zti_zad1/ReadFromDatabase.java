package com.example.zti_zad1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ReadFromDatabase", value = "/ReadFromDatabase")
public class ReadFromDatabase extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/your_username";
            String username = "your_username";
            String password = "your_user_pass";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM public.person";
            ResultSet rs = stmt.executeQuery(sql);
            List<Person> people = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("city"));
                people.add(person);
            }
            request.setAttribute("people", people);
            request.getRequestDispatcher("/mvc/Read.jsp").forward(request, response);
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {

        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
