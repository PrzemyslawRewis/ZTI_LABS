package com.example.zti_zad1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/")
public class SimpleMVC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        ServletContext sc = getServletConfig().getServletContext();
        switch (path){
            case ("/mvc/Read.jsp"):
                sc.getRequestDispatcher("/mvc/Read.jsp").forward(request, response);
                break;
            case("/mvc/Save.jsp"):
                sc.getRequestDispatcher("/mvc/Save.jsp").forward(request, response);
                break;
            default:
                sc.getRequestDispatcher("/mvc/Home.jsp").forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
