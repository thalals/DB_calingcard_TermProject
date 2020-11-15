<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//connection 클래스와 driver클래스는 java.sql.* 패키지에 속해있다.
	Connection conn=null;
	PreparedStatement ps = null;	//sql문 실행을 위한 객체
	
	int idd=Integer.parseInt(request.getParameter("CardNumber"));
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/detol?serverTimezone=UTC";
	
	
	try{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,"root","1234");	//데이터베이스 연결 요청
		String sql="delete from card where CardNumber=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, idd);
		ps.executeUpdate();
%>
<%
	}catch(Exception e){
	e.printStackTrace();
	}
	finally{
		response.sendRedirect("maintest.jsp");
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
%>
</body>
</html>