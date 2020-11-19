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
	request.setCharacterEncoding("UTF-8");	//넘어 오는거 한글처리
	


	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		Context cp = new InitialContext();
		DataSource ds = (DataSource)cp.lookup("java:comp/env/jdbc/detol");
		conn = ds.getConnection();
		
		String sql ="select * from organization where OrgNumber = ?";
		ps = conn.prepareStatement(sql);
		
		String id =  String.valueOf(request.getAttribute("Org_number"));
		
		System.out.println("전화번호 추가되는 회사 번호 :  " + id);
		
		ps.setInt(1, Integer.parseInt(id));
		
		OrgDAO orgDAO = new OrgDAO();
		
		rs = ps.executeQuery();
		
		ArrayList<OrgCallNumber> orgCall_list = orgDAO.getOrgnum_list(Integer.parseInt(id));
		
		
		
		if(rs.next()){
			%>
			<form name="updateform" action="org_info" method="post">
			<table border=1>
				<tr>
					<td colspan="2" class = "td_title">
						<%=rs.getString("OrgName") %> 번호 추가
					</td>
				</tr>
				
				<%for (OrgCallNumber a : orgCall_list){ %>
					
					<tr>
						<td><label for = "number">전화번호 : </label></td>
						<td><input type="text" name="a"  disabled value=<%=a.getCallNumber() %>  /></td>
					</tr>
					
				<%} %>
				<tr>
					<td><label for = "number">전화번호 : </label></td>
					<td><input type="text" name="number"  /></td>
					<input type="hidden" name ="id" value =<%=rs.getInt("OrgNumber")%> >
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" name ="btn" value ="회사 전화 번호 추가">
						<input type="submit" name ="btn" value ="번호 추가 완료">
					</td>
				</tr>
			</table>
			</form>
			
		<%	
		}
		else{
			out.println("<script>");
			out.println("location.href='maintest2.jsp'");
			out.println("</script>");
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if( ps != null) ps.close();
		if( conn != null) conn.close();
	}
	
%>

</body>

</html>

