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
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/create.css">
<link rel="stylesheet" href="css/default2.css">
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
<form action="org_info" method="POST" class="select_form">
<div class="orginfo_main">
<table>
<tr>
<td class="create_card_left">
	소속단체 이름 : 
</td>
<td class="create_card_right2">
	<%=org.getOrgName() %>
</td>
</tr>
<tr>
<td class="create_card_left">
	소속단체 주소 :
</td>
<td class="create_card_right2">
	<%=org.getOrgAddress() %>
</td>
</tr>
<tr>
<td class="create_card_left">
	소속단체 우편번호 :
</td>
<td class="create_card_right2">
	<%=org.getOrgZipCode() %>
</td>
</tr>
<tr>
<td class="create_card_left">
	소속단체 팩스 :
</td>
<td class="create_card_right2">
	<%=org.getOrgemail() %>
</td>
</tr>
<tr>
<td class="create_card_left">
	소속단체 이메일 :
</td>
<td class="create_card_right2">
	<%=org.getOrgfax() %>
</td>
</tr>
<%
OrgCallNumber orgcallnumber=new OrgCallNumber();
orgcallnumber=orgDAO.getOrgNumber(num);
%>
<tr>
<td class="create_card_left">
	소속단체 전화번호 : 
</td>
<td class="create_card_right2">
	<%=orgcallnumber.getCallNumber() %>
</td>
</tr>
</table>
<input type="hidden" value="<%= num%>" name="choice">
<center>
<input type="submit"  value="소속단체 수정" name="btn" id = "select_btn" class="update_org">
</center>
</div>
</form>
</body>
</html>