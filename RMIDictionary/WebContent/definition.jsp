<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RMI Dictionary</title>
</head>
<body> 
	<h1>Result</h1>
	<%
		String query = (String) request.getAttribute("query");
		String result = (String) request.getAttribute("result");
		//out.print(query + ": " + result);
	%>
	<em style="margin:10px]"><% out.print(query); %></em> is defined as...
	<br />
	<p style="margin: 20px"><% out.print(result); %></p>
	<p><a href="homepage.jsp" id="Home">Back</a></p>
</body>
</html>