<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String Name=(String)request.getAttribute("Name");
	String Address=(String)request.getAttribute("Address");
	String Zipcode=(String)request.getAttribute("Zipcode");
	String Email=(String)request.getAttribute("Email");
	String Fax=(String)request.getAttribute("Fax");
%>
<table>
<tr>
<td>
	<%=Name %>
</td>
</tr>
<tr>
<td>
	<%=Address %>
</td>
</tr>
<tr>
<td>
	<%=Zipcode %>
</td>
</tr>
<tr>
<td>
	<%=Email %>
</td>
</tr>
<tr>
<td>
	<%=Fax %>
</td>
</tr>
</table>
</body>
</html>