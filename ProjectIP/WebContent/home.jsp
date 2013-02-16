<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>
</head>

<body background="image.jpg">
<f:view>

	<h:form>
		<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","surgeon");
		PreparedStatement statement = con.prepareStatement("select data, result from math");
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			out.println(result.getString(1) + " = " + result.getString(2) + "<br>");
		}
		%>
		<center>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<h:commandButton value="Input again?" action = "again"/>
		</center>
	</h:form>

</f:view>
</body>

</html>