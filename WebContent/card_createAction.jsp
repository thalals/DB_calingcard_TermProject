<%@page import="card.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="card" class="card.Card" scope="page" />
<jsp:setProperty name="card" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 추가 액션</title>
</head>
<body>
<%
	//이름과 번호가 입력이 안되면 다시 입력하게
	if(request.getParameter("Name")==null || request.getParameter("PhoneNumber")==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else{
		CardDAO cardDAO = new CardDAO();
		card.setName(request.getParameter("Name"));
		card.setPhoneNumber(request.getParameter("phoneNumber"));
		card.setTeam(request.getParameter("Team"));
		card.setEmail(request.getParameter("Email"));
		card.setPosition(request.getParameter("Position"));
		card.setCareer(request.getParameter("Career"));
		
		System.out.println("card : "+card);
		//CardDAO클래스의 addCard()함수 사용
		int result = cardDAO.addCard(card);
		//System.out.println(result);
		//명함 추가 실패했을 경우
		if (result == -1 ){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('명함 추가에 실패하였습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		//명함 추가 성공했을 경우
		else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'list.jsp'");
			script.println("</script>");
		}
	}
%>

</body>
</html>