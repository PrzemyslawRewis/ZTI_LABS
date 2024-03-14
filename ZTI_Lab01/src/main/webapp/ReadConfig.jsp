<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Read My Config File - scriplets</title>
</head>
<body>
<%
    // Tomcat
    java.io.InputStream is = this.getClass().getClassLoader().getResourceAsStream("../myConf.ini");
    // WAS Liberty
    // java.io.InputStream is = this.getClass().getClassLoader().getResourceAsStream("/WEB-INF/myConf.ini");
    java.util.Properties p = new java.util.Properties();
    System.out.println("Test-B");
    try {
        p.load(is);
        out.println("<p>Test1 = " + p.getProperty("Test1") + "</p>");
        out.println("<p>Test2 = " + p.getProperty("Test2") + "</p>");
        out.println("<p>Test3 = " + p.getProperty("Test3") + "</p>");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("Test-C");
%>

</body>
</html>