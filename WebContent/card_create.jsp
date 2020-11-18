<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/create.css">
<link rel="stylesheet" href="css/default2.css">
<% //response.setContentType("text/html; charset=euc-kr"); %>
<%//response.setCharacterEncoding("euc-kr"); %>

<title>명함 추가</title>
</head>
<body>

<% String OrgNumber = (String)request.getAttribute("Org_Number"); %>

<form method="post" action="card_create">
    <div class="card_create_login">
        <p> 이름 </p>
        
        <div class = "input_text">
            <input type="text" id="Name" name="Name" placeholder="성명">
        </div>
        <p> 핸드폰 번호 </p>
        
        <div class = "input_text">
            <input type="text" id="PhoneNumber" name="PhoneNumber" placeholder="숫자만 입력해 주세요">
        </div>
        <p> 부서 </p>
       
        <div class = "input_text">
            <input type="text" id="Team" name="Team" placeholder="없으면 입력하지 않으셔도 됩니다">
        </div>
        <p> 직책 </p>
        <div class = "input_text">
            <input type="text" id="Position" name="Position" placeholder="없으면 입력하지 않으셔도 됩니다">
        </div>
        <p> 이메일 </p>
        <div class = "input_text">
            <input type="text" id="Email" name="Email" placeholder="없으면 입력하지 않으셔도 됩니다">
        </div>
        <p> 경력 </p>
        <div class = "input_text">
            <input type="text" id="Career" name="Career" placeholder="없으면 입력하지 않으셔도 됩니다">
        </div>
        
        
        <input type="hidden" name="Org_number" value = '<%=OrgNumber %>' >
        <input type="hidden" name="user_id" value = '${ id }' >
        <center>
        <input type="submit" class="btn_card_create" name="btn" value="카드추가">	
        </center>
    </div>
    </form>
</form>
</body>
</html>
