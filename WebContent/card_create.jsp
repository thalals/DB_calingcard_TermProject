<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 추가</title>
</head>
<body>
<form method="post" action="card_createAction.jsp">
<p> 이름 : </p>
<input type="text" placehorder="성명" name="Name" maxlength="30">
<p> 핸드폰 번호 : </p>
<input type="text" placehorder="숫자만 입력해 주세요" name="PhoneNumber" maxlength="30">
<p> 부서 : </p>
<input type="text" placehorder="없으면 입력하지 않으셔도 됩니다." name="Team" maxlength="30">
<p> 직책 : </p>
<input type="text" placehorder="없으면 입력하지 않으셔도 됩니다." name="Position" maxlength="30">
<p> 이메일 : </p>
<input type="text" placehorder="없으면 입력하지 않으셔도 됩니다." name="Email" maxlength="30">
<p> 경력 : </p>
<input type="text" placehorder="없으면 입력하지 않으셔도 됩니다." name="Career" maxlength="30">
<input type="submit" value="추가">
</form>
</body>
</html>
