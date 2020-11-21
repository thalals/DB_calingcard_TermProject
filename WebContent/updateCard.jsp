<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String id = (String)request.getAttribute("card_number"); %>
<% CardDAO cardDAO = new CardDAO();  %>
<% Card card = new Card(); %>
<% card = cardDAO.selectCard(id); %>
<% System.out.println("id 확인 : " +id);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/create.css">
<link rel="stylesheet" href="css/default2.css">
<title>명함 수정</title>
</head>
<body>
<form method="post"  action="card_create" class="update_create">
<%
	/*int x=(int)request.getAttribute("Org_Number");
	System.out.println(x);*/
%>
<div class="update_create">
<table>
	<tr>
	<td class="create_card_left">
    <p> 이름 : </p>
    </td>
    <td class="create_card_right">
    <div class = "input_text">
        <input class="text2" type="text" class="form-control" placehorder="성명" name="upName" value = "<%=card.getName() %>" maxlength="30">
    </div>
    </td>
    </tr>
    <tr>
	<td class="create_card_left">
    <p> 핸드폰 번호 : </p>
    </td>
    <td class="create_card_right">
    <div class = "input_text">
        <input class="text2" type="text" class="form-control" placehorder="숫자만 입력해 주세요" name="upPhoneNumber"  value = "<%=card.getPhoneNumber() %>" maxlength="30">
    </div>
     </td>
    </tr>
    <tr>
	<td class="create_card_left">
    <p> 부서 : </p>
    </td>
    <td class="create_card_right">
    <div class = "input_text">
        <input class="text2" type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upTeam"  value = "<%=card.getTeam()%>"maxlength="30">
    </div>
     </td>
    </tr>
    <tr>
	<td class="create_card_left">
    <p> 직책 : </p>
    </td>
    <td class="create_card_right">
    <div class = "input_text">
        <input class="text2" type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upPosition" value = "<%=card.getPosition() %>" maxlength="30">
    </div>
    </td>
    </tr>
    <tr>
	<td class="create_card_left">
    <p> 이메일 : </p>
    </td>
    <td class="create_card_right">
    <div class = "input_text">
        <input class="text2" type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upEmail"  value = "<%=card.getEmail() %>" maxlength="30">
    </div>
    </td>
    </tr>
    <tr>
	<td class="create_card_left">
    <p> 경력 : </p>
    </td>
    <td class="create_card_right">
    <div class = "input_text">
        <input class="text2" type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="upCarrer"  value = "<%=card.getCareer() %>" maxlength="30">
    </div>
    </td>
    </tr>
</table>
    <input type ="hidden" name="upid" value = "<%=card.getCardNumber() %>">
    <center>
        <input type="submit" class="btn_update_card" name="btn" value="카드수정">
    </center>	

</div>

</form>
</body>
</html>
