<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MVC Project - Zapis</title>
</head>
<body>
<%-- include menu.jsp in this JSP --%>
<jsp:include page="Menu.jsp" flush="true"/>

<h1>Zapis do bazy danych</h1>
<form action="/ZTI_zad1_war_exploded/SaveToDatabase" method="post">
    <label>Imię:</label><br>
    <input type="text" name="firstName" required><br>
    <label>Nazwisko:</label><br>
    <input type="text" name="lastName" required><br>
    <label>Miasto:</label><br>
    <input type="text" name="city" required><br>
    <input type="submit" value="Zapisz">
</form>
</body>
</html>