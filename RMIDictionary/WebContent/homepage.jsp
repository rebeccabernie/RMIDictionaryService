<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RMI Dictionary</title>
</head>
<body>
	<h2>Give me the definition for...</h2> 
	<form action="DictServlet" method="POST">
	   <input style="margin: 10px" type="text" name="query">
	   <br>
	   <br>
	   <input style="margin: 10px" type="submit" value="Submit"/>
	</form>

	<br>
	<br>
	<form action="DictServlet" method="GET">
		<%
			String message = (String) request.getParameter("message"); // Get message variable
			if (message != null) // If the message contains something (definition / error), output that
				out.print(request.getParameter("message"));
			else
				out.print("Please enter a word."); // Otherwise display prompt
		%>
	</form>
	
</body>
</html>