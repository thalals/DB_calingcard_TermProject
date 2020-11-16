<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@page import="java.util.ArrayList"%>
<%@ page import ="vo.*" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="org_info" method="POST">
		<table>
			<tr>
				<td>
				<%
					int count=0;
					OrgDAO orgDAO = new OrgDAO();
					ArrayList<Org> orgname_list = orgDAO.getOrglist();
				%>
					<select name="choice">
				<% 
					for(Org a:orgname_list){
						
				%>
					<option value="<%=a.getOrgName() %>"><%=a.getOrgName() %></option>
				<%
					}
				%>
					</select>
				</td>
				<td>
					<input type="submit" value="추가" name="btn">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="다음" name="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>