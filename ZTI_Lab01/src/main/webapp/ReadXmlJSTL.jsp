<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP JSTL XML</title>
</head>
<body>
<h1>JSP - Read xml file with JSTL</h1>

<import var="file" url="http://localhost:8081/ZTI_Lab01_war_exploded/Data/data.xml" />
<parse var="doc" xml="${file}" />
<table border="1">
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Grade</th>
        <th>Type</th>
    </tr>
    <forEach select="$doc/students/student">
        <tr>
            <td><out select="data/fname" /></td>
            <td><out select="data/lname" /></td>
            <td><out select="results/grade" /></td>
            <td><out select="results/type" /></td>
        </tr>
    </forEach>
</table>
</body>
</html>