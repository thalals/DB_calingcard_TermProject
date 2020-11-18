<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@page import="java.util.ArrayList"%>
<%@ page import ="vo.*" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/orgselect.css">
<link rel="stylesheet" href="css/default2.css">
<title>회사 선택</title>
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
					사용자 : ${ id }	<br><br>				
					<select name="choice" class="org_select">
				<% 
					for(Org a:orgname_list){
						System.out.println("회사 넘버 제댈?: "+a.getOrg_Number());
				%>
					<option  value="<%=a.getOrg_Number() %>"><%=a.getOrgName() %></option>
				<%
					}
				%>
					</select>
                </td>
			</tr>
            <tr>
				<td>
					<input type="submit" value="추가" name="btn" class="add_org">
					<input type="submit" value="다음" name="btn" class="next_page">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>