<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register</title>
</head>

<body background="image.jpg">
<f:view>
		<h:form>
		<br><br><br><br><br><br><br>
		<center>
		<h:outputLabel value = "Username: " for = "username"/>
		<h:inputText value = "#{registerRequest.username}" id = "username"/>
		<br><br>
		<h:outputLabel value = "Password: " for = "password"/>
		<h:inputSecret value = "#{registerRequest.password}" id = "password"/>
		<br><br>
		<h:commandButton value="Create" action = "#{registerRequest.doRegister}"/>
		</center>
	</h:form>
</f:view>
</body>

</html>