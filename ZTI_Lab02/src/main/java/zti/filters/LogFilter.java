package zti.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter implements Filter {

    protected FilterConfig config;
    private ServletContext context;
    private String filterName;


    LogFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        context.log(" Zdalny serwer: " + req.getRemoteHost() + " - wywołał " + req.getRequestURL() + " w dniu " + new Date() + "." + "(Raport wygenerowany przez " + filterName + ".)");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        this.config = fConfig;
        context = config.getServletContext();
        filterName = config.getFilterName();
    }

}