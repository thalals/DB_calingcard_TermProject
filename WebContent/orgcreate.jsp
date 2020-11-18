<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/create.css">
<link rel="stylesheet" href="css/default2.css">
<title>명함 추가</title>
</head>
<body>
<form method="post" action="org_info">
<div class="card_create_login">
        <p> 단체 이름 </p>
        
        <div class = "input_text">
            <input type="text" id="OrgName" name="OrgName" placeholder="name">
        </div>
        <p> 단체 주소 </p>
        
        <div class = "input_text">
            <input type="text" id="OrgAddress" name="OrgAddress" placeholder="address">
        </div>
        <p> 단체 우편번호 </p>
       
        <div class = "input_text">
            <input type="text" id="OrgZipCode" name="OrgZipCode" placeholder="zipcode">
        </div>
        <p> 단체 이메일 </p>
        <div class = "input_text">
            <input type="text" id="Orgemail" name="Orgemail" placeholder="email">
        </div>
        <p> 단체 팩스번호 </p>
        <div class = "input_text">
            <input type="text" id="Orgfax" name="Orgfax" placeholder="fax">
        </div>
        
        <p> ${ id } </p>
        <center>
	    	<input type="submit" class=btn_org_create name="btn" value="회사생성">
        </center>
        
    </div>
	
</form>
</body>
</html>
