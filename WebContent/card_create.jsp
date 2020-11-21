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

<form method="post" action="card_create" class="card_create">
    <div class="card_create_login">
    <table>
	    <tr>
		    <td class="create_card_left">
		        <p> 이름 </p>
		    </td>
		    <td class="create_card_right">
		        <div class = "input_text">
		            <input class="text2" type="text" id="Name" name="Name" placeholder="성명" >
		        </div>
		    </td>
	    </tr>
	    <tr>
		    <td class="create_card_left">
		        <p> 핸드폰 번호 </p>
		    </td>
		    <td class="create_card_right">
		        <div class = "input_text">
		            <input type="text" class="text2" id="PhoneNumber" name="PhoneNumber"  default=" " placeholder="숫자만 입력해 주세요">
		        </div>
		    </td>
	    </tr>
	    <tr>
	    <td class="create_card_left">
	        <p> 부서 </p>
	    </td>
	    <td class="create_card_right">
	        <div class = "input_text">
	            <input type="text" class="text2" id="Team" name="Team"  default=" " placeholder="없으면 입력하지 않으셔도 됩니다">
	        </div>
	    </td>
	    </tr>
	    <tr>
	    <td class="create_card_left">
	        <p> 직책 </p>
	    </td>
	    <td class="create_card_right">
	        <div class = "input_text">
	            <input type="text" class="text2" id="Position" name="Position"  default=" " placeholder="없으면 입력하지 않으셔도 됩니다">
	        </div>
	    </td>
	    </tr>
	    <tr>
	    <td class="create_card_left">
	        <p> 이메일 </p>
	    </td>
	    <td class="create_card_right">
	        <div class = "input_text">
	            <input type="text" class="text2" id="Email" name="Email"  default=" " placeholder="없으면 입력하지 않으셔도 됩니다">
	        </div>
	    </td>
	    </tr>
	    <tr>
	    <td class="create_card_left">
	        <p> 경력 </p>
	    </td>
	    <td class="create_card_right">
	        <div class = "input_text">
	            <input type="text" class="text2" id="Career" name="Career" default=" " placeholder="없으면 입력하지 않으셔도 됩니다">
	        </div>
	    </td>
	    </tr> 
     </table>
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
