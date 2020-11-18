<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import ="vo.*" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.servlet.*" %>
<jsp:useBean id="card" class="vo.Card" scope="page" />
<jsp:setProperty name="card" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/default2.css">
<!-- 부트스트랩 사용하기 위해 링크 -->


<title>login 페이지</title>
</head>
<body>
	<div class="mainboard">
		<div class="clo-lg-4"></div>
		<div class="clo-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
			
				<form action = "card_create" method = "post" >
                    <div class="page_name">
					    <h3>명함 한눈에 보기</h3>
                    </div>
					<% 
						int count =0 ;
						CardDAO cardDAO = new CardDAO();
						ArrayList<Card> card_list = cardDAO.getCardlist(); 		
						
						
						 %>
						<!-- EL 문법 -->
						사용자 : ${ id } , <br><br>
						
						<%
						for(Card a : card_list){
							//pass.equals(rs.getString("password")
							//String b = a.getUserID();
							//session.setAttribute("id", a.getUserID());
							//String c = (String)session.getAttribute("id");
							//System.out.println(a.getUserID().getClass().getName());
							//System.out.println(session.getAttribute("id").getClass().getName());
							//if(a.getUserID() ==session.getAttribute("id")  ){
								if(a.getUserID().equals(session.getAttribute("id"))){
                            %>
                            <table class="card_table">
								<tr>
								<td>작성자  : <%=a.getUserID() %> | </td>
								
                                <td>카드번호  : <%=a.getCardNumber() %> | </td>
                                </tr>
                                <tr>
                                    <td><%= a.getName() %></td>
                                <tr>
                                    <td><%=a.getPhoneNumber() %></td>
                                </tr>
                                <tr>
                                    <td><%=a.getTeam() %></td>
                                </tr>   
                                <tr>
                                    <td><%=a.getPosition() %></td>
                                </tr>
                                <tr>
                                    <td><%=a.getCareer() %></td>
                                </tr>
                                <tr>
								    <td>최종 수정 일자 : <%=a.getSaveDate() %></td>
								</tr>
								
								<td>
									
	 								<input type = "hidden" name = "card_number" value ='<%=a.getCardNumber() %>'>
									<input type = "submit" name = "btn" value = "삭제">
									<input type = "submit" name = "btn" value = "수정">
									
                                </td>
                            </table>
								<br>
						<%		
							}
							else{
								System.out.println("null값입니다.");
							}
						
						count++;
						}
					
					
					if(count==0){
						%>
						<tr><td colspan="7">작성한 게시글이 없습니다.</td></tr>		
					<%
					}
					%>
					 
					
				</form>
				<form action="org_info" method="POST">
					<input type ="hidden" name="user_id" value='${ id }' >
					<input type="submit" class="btn btn-primary form-control" name="btn" value="명함 생성">	
				</form>	
			</div>
		</div>
	</div>
	
	
</body>
</html>