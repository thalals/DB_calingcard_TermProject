<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명함 추가</title>
</head>
<body>
<form method="post" action="org_info">
	<p> 단체 이름 : </p>
	<input type="text" class="form-control" placehorder="name" name="OrgName" maxlength="30">
	<p> 단체 주소 : </p>
	<input type="text" class="form-control" placehorder="address" name="OrgAddress" maxlength="30">
	<p> 단체 우편번호 : </p>
	<input type="text" class="form-control" placehorder="zipcode" name="OrgZipCode" maxlength="30">
	<p> 단체 이메일 : </p>
	<input type="text" class="form-control" placehorder="email" name="Orgemail" maxlength="30">
	<p> 단체 팩스번호 : </p>
	<input type="text" class="form-control" placehorder="fax" name="Orgfax" maxlength="30">
	
	<input type="submit" name="btn" value="생성">
</form>
</body>
</html>
