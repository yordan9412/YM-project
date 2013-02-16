<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Error</title>
</head>

<body background="image.jpg">
<f:view>

	<h:form>
		<br><br><br><br><br><br><br>
		<center>
			Wrong input!
			<br><br>
			<h:commandButton value="Try again?" action = "try"/>
		</center>
	</h:form>

</f:view>
</body>
</html>