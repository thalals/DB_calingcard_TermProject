<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.io.*" %>
<%@ page import ="card.*" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함관리 리스트</title>
</head>
<body>
나오냐
<%
	CardDAO cardDAO = new CardDAO();
	ArrayList<Card> list = cardDAO.getList();
	out.println("여기는 나오냐 " +list.size() );
	for(int i =0;i<list.size();i++){
		out.println("여기는 나오냐 " +list.size() );

%>
		카드번호 : <%=list.get(i).getCardNumber() %><br>	
		유저번호 : <%=list.get(i).getUserNumber() %>	<br>
		회사번호 : <%=list.get(i).getOrgNumber() %>	<br>	
		이름 : <%=list.get(i).getName() %>	<br>
		전화번호 : <%=list.get(i).getPhoneNumber() %><br>	
		부서 : <%=list.get(i).getTeam() %><br>
		직책 : <%=list.get(i).getPosition() %><br>	
		이메일 : <%=list.get(i).getEmail() %><br>
		경력 : <%=list.get(i).getCareer() %><br>	
		저장일자 : <%=list.get(i).getSaveDate() %><br><br>	<br>
<table>
	<tr>
		<td>카드번호 : <%=list.get(i).getCardNumber() %></td>	
		<td>카드번호 : <%=list.get(i).getUserNumber() %></td>		
		<td>카드번호 : <%=list.get(i).getOrgNumber() %></td>		
		<td>이름 : <%=list.get(i).getName() %></td>	
		<td>전화번호 : <%=list.get(i).getPhoneNumber() %></td>	
		<td>부서 : <%=list.get(i).getTeam() %></td>	
		<td>직책 : <%=list.get(i).getPosition() %></td>	
		<td>이메일 : <%=list.get(i).getEmail() %></td>	
		<td>경력 : <%=list.get(i).getCareer() %></td>	
		<td>저장일자 : <%=list.get(i).getSaveDate() %></td>	
	</tr>
</table>
<%} %>
</body>
</html>