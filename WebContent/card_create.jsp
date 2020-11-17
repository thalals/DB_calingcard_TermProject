<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">

<% //response.setContentType("text/html; charset=euc-kr"); %>
<%//response.setCharacterEncoding("euc-kr"); %>

<title>명함 추가</title>
</head>
<body>

<% String OrgNumber = (String)request.getAttribute("Org_Number"); %>

<form method="post" action="card_create">

<p> 이름 : </p>
<input type="text" class="form-control" placehorder="성명" name="Name" maxlength="30">
<p> 핸드폰 번호 : </p>
<input type="text" class="form-control" placehorder="숫자만 입력해 주세요" name="PhoneNumber" maxlength="30">
<p> 부서 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="Team" maxlength="30">
<p> 직책 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="Position" maxlength="30">
<p> 이메일 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="Email" maxlength="30">
<p> 경력 : </p>
<input type="text" class="form-control" placehorder="없으면 입력하지 않으셔도 됩니다." name="Career" maxlength="30">



<input type="hidden" name="Org_number" value = '<%=OrgNumber %>' >
<input type="hidden" name="user_id" value = '${ id }' >
<input type="submit" class="btn btn-primary form-control" name="btn" value="카드추가">	
</form>
</body>
</html>
