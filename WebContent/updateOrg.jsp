<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String id = (String)request.getAttribute("org_number"); %>
<% OrgDAO orgDAO = new OrgDAO();  %>
<% Org org = new Org(); %>
<% org = orgDAO.getOrgN(id); %>
<% System.out.println("id 확인 : " +id);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/create.css">
<link rel="stylesheet" href="css/default2.css">
<title>회사 수정</title>
</head>
<body>

<form method="post" action="org_info" class="org_create">
<div class="card_create_login">
<table>
    <tr>
    <td class="create_card_left">
        <p> 단체 이름 </p>
    </td>
    <td class="create_card_right">
        <div class = "input_text">
            <input class="text2" type="text" id="OrgName" name="upOrgName" placeholder="name"  value = "<%=org.getOrgName()%>">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">
        <p> 단체 주소 </p>
    </td>
    <td class="create_card_right">    
        <div class = "input_text">
            <input class="text2" type="text" id="OrgAddress" name="upOrgAddress" placeholder="address" value = "<%=org.getOrgAddress()%>">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">   
        <p> 단체 우편번호 </p>
    </td>
    <td class="create_card_right">   
        <div class = "input_text">
            <input class="text2" type="text" id="OrgZipCode" name="upOrgZipCode" placeholder="zipcode" value = "<%=org.getOrgZipCode()%>">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">   
        <p> 단체 이메일 </p>
    </td>
    <td class="create_card_right"> 
        <div class = "input_text">
            <input class="text2" type="text" id="Orgemail" name="upOrgemail" placeholder="email" value = "<%=org.getOrgemail()%>">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">  
        <p> 단체 팩스번호 </p>
    </td>
    <td class="create_card_right"> 
        <div class = "input_text">
            <input class="text2" type="text" id="Orgfax" name="upOrgfax" placeholder="fax" value = "<%=org.getOrgfax()%>">
        </div>
    </td>
    </tr>
    
</table>
 
        
        <center>
    <input type ="hidden" name="upid" value = "<%=org.getOrg_Number() %>">
	    	<input type="submit" class=btn_org_create name="btn" value="회사 수정">
        </center>
        
    </div>
	
</form>
</body>
</html>
