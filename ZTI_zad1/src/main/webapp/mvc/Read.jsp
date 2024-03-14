<%@ page import="com.example.zti_zad1.Person" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MVC Project - Odczyt</title>
</head>
<body>
<%-- include menu.jsp in this JSP --%>
<jsp:include page="Menu.jsp" flush="true"/>

<h1>Odczyt z bazy danych</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Miasto</th>
    </tr>
    <tbody>
    <%
        request.getRequestDispatcher("/ReadFromDatabase").include(request,response);
        List<Person> people = (List<Person>) request.getAttribute("people");
        for (Person person : people) {
    %>
    <tr>
        <td><%= person.getId() %></td>
        <td><%= person.getFirstName() %></td>
        <td><%= person.getLastName() %></td>
        <td><%= person.getCity() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>