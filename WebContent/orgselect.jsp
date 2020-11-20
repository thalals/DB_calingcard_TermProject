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

<style type="text/css">
#select_btn {
	display:inline;
	width : 80px;
}

form{display:inline-block;}
</style>
<title>회사 선택</title>
</head>
<body>
	<form action="org_info" method="POST" class="select_form">
		<table>
			<tr>
				<td>
				<%
					int count=0;
					OrgDAO orgDAO = new OrgDAO();
					ArrayList<Org> orgname_list = orgDAO.getOrglist();
					
				%>
					사용자 : ${ id }	<br><br>				
				<% 
					for(Org a:orgname_list){
						
				%>
				<div>
				<div>
					<input type="radio" name="choice" value="<%=a.getOrg_Number() %>"><%=a.getOrgName() %></option>
					| (주소) : <%=a.getOrgAddress() %> | (우편번호) : <%=a.getOrgZipCode() %> |<!--  (email) : <%=a.getOrgfax() %> | (fax) : <%=a.getOrgemail() %> | -->
					<hr>
					<div class="btn_div">
					<input type="hidden" value ="<%=a.getOrg_Number() %>" name = "org_number">
					<input type="submit"  value="수정" name="btn" id = "select_btn" class="update_org">
					<input type ="submit"  value="다음" name="btn" id = "select_btn" class="next_page" style="backgroun-color:black;"> <br>
					</div>
				</div>	
				<%
					}
				%>
					
                </td>
			</tr>
            <tr>
				<td>
					<input type="submit" value="추가" name="btn" class="add_org">
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>