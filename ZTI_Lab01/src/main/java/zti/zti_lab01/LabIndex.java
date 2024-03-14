package zti.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LabIndex", value = "/LabIndex")
public class LabIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println ("<title>ZTI - Lab01</title>");

        out.println ("<h1>ZTI - Lab01 : Servlets and JSP scripts </h1>");
        out.println ("<ol>");
        out.println ("<li><a href='Servlet01'>[Servlet] First Servlet</a></li>");
        out.println ("<li><a href='ReadReqParam'>[Servlet] Read Request Parameter</a></li>");
        out.println ("<li><a href='FormData.html'>[Servlet] Read the data from the html form</a></li>");
        out.println ("<li><a href='ReadRecDB'>[Servlet (JDBC)] Read the records from the PostgreSQL database</a></li>");
        out.println ("<li><a href='HelloJSP.jsp'>[JSP] Read the JavaBean in JSP script</a></li>");
        out.println ("<li><a href='SimpleMVC'>[Servlet & JSP] Simple MVC pattern - dispatch servlet</a></li>");
        out.println ("<li><a href='ReadXmlJSTL.jsp'>[JSP (JSTL)] Read the xml file in JSP script</a></li>");
        out.println ("<li><a href='ReadConfig.jsp'>[JSP] Read the config file in WEB-INF directory</a></li>");
        out.println ("</ol>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
