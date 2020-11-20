<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<% OrgDAO orgdao = new OrgDAO(); %>
<% int count  = 0; %>
<% String a= request.getParameter("count_a"); %>
<% if(Integer.parseInt(a)!=0){ 
	count = Integer.parseInt(a);
}%>
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
<form method="post" action="org_info" class="org_create">
<div class="card_create_login">
<table>
    <tr>
    <td class="create_card_left">
        <p> 단체 이름 </p>
    </td>
    <td class="create_card_right">
        <div class = "input_text">
            <input type="text" id="OrgName" name="OrgName" placeholder="name">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">
        <p> 단체 주소 </p>
    </td>
    <td class="create_card_right">    
        <div class = "input_text">
            <input type="text" id="OrgAddress" name="OrgAddress" placeholder="address">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">   
        <p> 단체 우편번호 </p>
    </td>
    <td class="create_card_right">   
        <div class = "input_text">
            <input type="text" id="OrgZipCode" name="OrgZipCode" placeholder="zipcode">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">   
        <p> 단체 이메일 </p>
    </td>
    <td class="create_card_right"> 
        <div class = "input_text">
            <input type="text" id="Orgemail" name="Orgemail" placeholder="email">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">  
        <p> 단체 팩스번호 </p>
    </td>
    <td class="create_card_right"> 
        <div class = "input_text">
            <input type="text" id="Orgfax" name="Orgfax" placeholder="fax">
        </div>
    </td>
    </tr>
    <tr>
    <td class="create_card_left">  
        <p> 회사 번호 추가</p>
    </td>
    <td class="create_card_right"> 
        <div class = "input_text">
        	<%System.out.println("카ㅏ웈"+count); %>
        	<%count++; %>
        	<a href="orgcreate.jsp?count_a=<%=count %>">
       		
       		
            <input type="button" id="Orgfax" name="Orgfax" value="<%=count %>개" placeholder="fax">
            </a>
        </div>
    </td>
    </tr>
    <%for(int i=0;i<count;i++) {%>
    	<tr>
    <td class="create_card_left">  
        <p> 단체 전화번호 </p>
    </td>
    <td class="create_card_right"> 
        <div class = "input_text">
            <input type="text" id="Orgfax" name="OrgCall<%=i+1 %>" placeholder="Call_Number">
        </div>
    </td>
    </tr>
    <%} %>
</table>
        
       
        
        <center>
	    	<input type="submit" class=btn_org_create name="btn" value="회사생성">
        </center>
        
    </div>
	
</form>
</body>
</html>
