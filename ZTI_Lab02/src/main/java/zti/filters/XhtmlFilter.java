package zti.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class XhtmlFilter implements Filter {

    public XhtmlFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession h = req.getSession();
        Locale locale = (Locale) h.getAttribute("locale");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (locale.equals(Locale.ENGLISH)) {
            out.println("<html>");
            out.println("<head><title>Error 404</title></head>");
            out.println("<body>");
            out.println("<h1>Sorry !!!</h1>");
            out.println("<h2> Called page: <span style='color:red'> " + req.getRequestURL() + "</span> is not available! ");
            out.println("</body></html>");
        } else {
            out.println("<html>");
            out.println("<head><title>Blad 404</title></head>");
            out.println("<body>");
            out.println("<h1>Przepraszamy !!!</h1>");
            out.println("<h2> Wywolana strona: <span style='color:red'> " + req.getRequestURL() + "</span> jest niedostepna w serwisie ! ");
            out.println("</body></html>");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}