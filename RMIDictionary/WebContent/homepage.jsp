<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RMI Dictionary</title>
</head>
<body>
	<h2 style="margin-left: 50px; margin-top: 50px"><em>Give me the definition for...</em></h2>
	<form action="DictionaryServlet" method="POST">
	   <input style="margin-left: 50px; margin-top: 20px" type="text" name="query">
	   <br>
	   <br>
	   <input style="margin-left: 50px; margin-top: 10px" type="submit" value="Go!"/>
	</form>

	<br>
	<br>
	<form style="margin-left: 50px; margin-top: 20px" action="DictionaryServlet" method="GET">
		<%
			String message = (String) request.getParameter("message"); // Get message variable
			//String waiting = "Waiting for response...";
					
			if (message != null) {// If the message contains something (definition / error), output that
				out.print(request.getParameter("message"));
			}
			else
				out.print("Please enter a word."); // Otherwise display prompt
		%>
	</form>
	
	<br>
	<br>
	<br>
	<br>
	<em style="font-size: 10px; margin-top:50px; margin-left:50px">Rebecca Kane, G00320698</em>
	
</body>
</html>