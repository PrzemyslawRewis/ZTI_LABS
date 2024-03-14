package zti.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SimpleMVC", value = "/SimpleMVC")
public class SimpleMVC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In the servlet. . .");
        // String site = request.getParameter("site");
        ServletContext sc = getServletConfig().getServletContext();
        RequestDispatcher rd = null;
        String site  = "";
        if (request.getParameterMap().containsKey("site")) {
            site = request.getParameter("site");
            System.out.println("Site parameter " + site );
        } else {
            rd = sc.getRequestDispatcher("/mvc/Home.jsp");
            rd.forward(request, response);
            return;
        }
        if ( site.equals("Site1")) {
            System.out.println("In the servlet. . . Site1");
            rd = sc.getRequestDispatcher("/mvc/Site1.jsp");
            rd.forward(request, response);
            return;
        } else if ( site.equals("Site2")) {
            System.out.println("In the servlet. . . Site2");
            rd = sc.getRequestDispatcher("/mvc/Site2.jsp");
            rd.forward(request, response);
            return;
        } else if ( site.equals("Site3")) {
            System.out.println("In the servlet. . . Site3");
            rd = sc.getRequestDispatcher("/mvc/Site3.jsp");
            rd.forward(request, response);
            return;
        } else {
            System.out.println("In the servlet. . . Home");
            rd = sc.getRequestDispatcher("/mvc/Home.jsp");
            rd.forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
