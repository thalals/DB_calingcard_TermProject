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
<% int x=Integer.parseInt(request.getParameter("num")); 
	System.out.println(x);
%>
<%
	Org org= new Org();
	OrgDAO orgDAO = new OrgDAO();
	String num=Integer.toString(x);
	org=orgDAO.getOrgN(num);
%>

<table>
<tr>
<td>
	<%=org.getOrgName() %>
</td>
</tr>
<tr>
<td>
	<%=org.getOrgAddress() %>
</td>
</tr>
<tr>
<td>
	<%=org.getOrgZipCode() %>
</td>
</tr>
<tr>
<td>
	<%=org.getOrgemail() %>
</td>
</tr>
<tr>
<td>
	<%=org.getOrgfax() %>
</td>
</tr>
<%
OrgCallNumber orgcallnumber=new OrgCallNumber();
orgcallnumber=orgDAO.getOrgNumber(num);
%>
<tr>
<td>
	<%=orgcallnumber.getCallNumber() %>
</td>
</tr>
</table>
</body>
</html>