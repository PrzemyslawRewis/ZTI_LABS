package zti.zti_lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadReqParam", value = "/ReadReqParam")
public class ReadReqParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.println("Protocol: " + request.getProtocol());
        out.println("Scheme: " + request.getScheme());
        out.println("ServerName: " + request.getServerName());
        out.println("ServerPort: " + request.getServerPort());
        out.println("RemoteAddr: " + request.getRemoteAddr());
        out.println("RemoteHost: " + request.getRemoteHost());
        out.println("Method: " + request.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
