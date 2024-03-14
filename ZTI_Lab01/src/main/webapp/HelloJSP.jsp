<html>
<head>
    <title>JSP and JavaBean</title>
</head>
<body>

<jsp:useBean id="dateBean" scope="request" class="zti.beans.DateBean" />
<h1>Odczyt danych z JavaBean</h1>
<br />
<p>Dzisiaj jest: ${dateBean.currentDate} !</p>

</body>
</html>

