<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.*"%>

<%@page import="javax.naming.*"%>
<%@page import="vo.*" %>
<%@page import="dao.*" %>
<%@page import="java.util.ArrayList"%>

<% request.setCharacterEncoding("UTF-8"); %>
    
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/create.css">
<link rel="stylesheet" href="css/default2.css">
<style>
	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
</style>
</head>

<body>
<%
		//회사 pk
		String id =  String.valueOf(request.getAttribute("Org_number"));
		
		System.out.println("전화번호 수정되는 회사 번호 :  " + id);

		OrgDAO orgDAO = new OrgDAO();
		
		Org org = orgDAO.getOrgN(id);
		ArrayList<OrgCallNumber> call = orgDAO.getOrgnum_list(Integer.parseInt(id));
		
		%>
			<form name="updateform" action="org_info" method="post">
			<table border=1>
				<tr>
					<td colspan="2" class = "td_title">
						<%=org.getOrgName() %> 번호 수정
					</td>
				</tr>
				
				<% if(call.size()==2) {%>
					<tr>
						<td class="create_card_left2"><label for = "number">전화번호1 : </label></td>
						<td class="create_card_right2"><input class="input_num" type="text" name="upnumber1" default=" " placeholder="call number" value="<%=call.get(0).getCallNumber() %>"/></td>
					</tr>
					
					<tr>
						<td class="create_card_left2"><label for = "number">전화번호2 : </label></td>
						<td class="create_card_right2"><input class="input_num" type="text" name="upnumber2" default=" " placeholder="call number" value="<%=call.get(1).getCallNumber() %>" /></td>
					</tr>
					
					<tr>
					<td colspan="2">
						<input type="hidden" name ="number1" value =<%=call.get(0).getCallNumber()%> >
						<input type="hidden" name ="number2" value =<%=call.get(1).getCallNumber()%> >
						<input type="hidden" name ="upid" value =<%=org.getOrg_Number()%> >
						<input type="submit" name ="btn" value ="회사 전화 번호 수정">
					</td>
				</tr>
				
				<% }
				
				else if(call.size()==1) {%>
					<tr>
						<td class="create_card_left2"><label for = "number">전화번호1 : </label></td>
						<td class="create_card_right2"><input class="input_num" type="text" name="upnumber1" default=" " placeholder="call number" value="<%=call.get(0).getCallNumber() %>"/></td>
					</tr>
					
					<tr>
						<td class="create_card_left2"><label for = "number">전화번호2 : </label></td>
						<td class="create_card_right2"><input class="input_num" type="text" name="upnumber2" default=" " placeholder="call number"  /></td>
					</tr>
					
					<tr>
					<td colspan="2">
						<input type="hidden" name ="number1" value =<%=call.get(0).getCallNumber()%> >
						<input type="hidden" name ="number2"  >
						<input type="hidden" name ="upid" value =<%=org.getOrg_Number()%> >
						<input type="submit" name ="btn" value ="회사 전화 번호 수정">
					</td>
				</tr>
				<% }
				
				else {%>
					<tr>
						<td class="create_card_left2"><label for = "number">전화번호1 : </label></td>
						<td class="create_card_right2"><input class="input_num" type="text" name="upnumber1" default=" " placeholder="call number" /></td>
					</tr>
					
					<tr>
						<td class="create_card_left2"><label for = "number">전화번호2 : </label></td>
						<td class="create_card_right2"><input class="input_num" type="text" name="upnumber2" default=" " placeholder="call number"  /></td>
					</tr>
					
					<tr>
					<td colspan="2">
						<input type="hidden" name ="number1"  >
						<input type="hidden" name ="number2"  >
						<input type="hidden" name ="upid" value =<%=org.getOrg_Number()+1%> >
						<input type="submit" name ="btn" value ="회사 전화 번호 수정">
					</td>
				</tr>
				<%} %>
				
				
			</table>
			</form>


</body>

</html>

