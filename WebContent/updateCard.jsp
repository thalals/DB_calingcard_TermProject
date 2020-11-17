<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String id = (String)request.getAttribute("id"); %>
<% CardDAO cardDAO = new CardDAO();  %>
<% Card card = new Card(); %>
<% card = cardDAO.selectCard(id); %>
<% System.out.println("id 확인 : " +id);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 수정</title>
</head>
<body>
<form method="post"  action="card_create" >
<%
	/*int x=(int)request.getAttribute("Org_Number");
	System.out.println(x);*/
%>
<p> 이름 : </p>
<input type="text" class="form-control" placehorder="성명" name="upName" value = "<%=card.getName() %>" maxlength="30">
<p> 핸드폰 번호 : </p>
<input type="text" class="form-control" placehorder="숫자만 입력해 주세요" name="upPhoneNumber"  value = "<%=card.getPhoneNumber() %>" maxlength="30">
<p> 부서 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upTeam"  value = "<%=card.getTeam()%>"maxlength="30">
<p> 직책 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upPosition" value = "<%=card.getPosition() %>" maxlength="30">
<p> 이메일 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upEmail"  value = "<%=card.getEmail() %>" maxlength="30">
<p> 경력 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upCarrer"  value = "<%=card.getCareer() %>" maxlength="30">

<input type ="hidden" name="upid" value = "<%=card.getCardNumber() %>">

<input type="submit" class="btn btn-primary form-control" name="btn" value="카드수정">	
</form>
</body>
</html>
