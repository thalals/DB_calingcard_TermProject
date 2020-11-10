<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user_login.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user_login.User" scope="page"/>
<jsp:setProperty name="user" property="userName"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPW"/>
<jsp:setProperty name="user" property="userEmail"/>

<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (user.getUserName() == null  || user.getUserID() == null || user.getUserPW() == null || user.getUserEmail() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else{
			UserDAO userDAO = new UserDAO();
			int result=userDAO.join(user);
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert(이미 존재하는 아이디입니다.)");
				script.println("history.back()");
				script.println("</script>");
			}else if(result >= 0){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href='maintest.jsp'");
				script.println("</script>");
			}
		}
	%>
</body>
</html>