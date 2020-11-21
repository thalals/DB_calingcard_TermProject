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
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/default2.css">
<!-- 부트스트랩 사용하기 위해 링크 -->


<title>login 페이지</title>
</head>
<body>
	<div class="mainboard" >
		<div class="clo-lg-4"></div>
		<div class="clo-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form action = "card_create" method = "post" class="main_form" >
				<table class="main_table">
					<tr>
						<td colspan="2">
		                    <div class="page_name">
							    <h3>명함 한눈에 보기</h3>
		                    </div>
	                    </td>
                    </tr>
					<% 
						int count =0 ;
						CardDAO cardDAO = new CardDAO();
						ArrayList<Card> card_list = cardDAO.getCardlist(); 		
					%>
					<tr>
						<td>
								<!-- EL 문법 -->
								사용자 : ${ id }  
						</td>
                     	<td align:right;>
                            <div class="btn_logou">
                            	<input type = "submit" name = "btn" value = "로그아웃" class="btn_logout">
                            </div>
                        </td>
                    </tr>	
					<tr>
					<td colspan="2">
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
	                   
	                    <table class="table_info">
							<tr colspan="2">
								<td>작성자  : <%=a.getUserID() %> | </td>
                              	<td>카드번호  : <%=a.getCardNumber() %> | </td>
                            </tr>
                        </table>
                            <table class="card_table">
                            	<tr>
                            		<td class="card_s"></td>
                            		<td class="card_c"></td>
                            		<td class="card_h"></td>
                            	</tr>
                                <tr>
                                	<td><%=a.getOrgNumber() %></td>
                                	<td></td>
                                    <td style="text-align:right;"><%= a.getName() %></td>
                                    
                                </tr>
                                <tr>
                                	<td>
                                	<%int x=a.getOrgNumber(); %>
                                	<input type="text" name="org_num" value=<%=x %>>
                                	
                                	<input type = "submit" class="" name = "btn" value = "회사 정보"></td>
                                	<td></td>
                                    <td style="text-align:right;"><%=a.getTeam() %> | <%=a.getPosition() %></td>
                                </tr>
                                <tr>
                                	<td ></td>
                                	<td></td>
                                    <td style="text-align:right;"><%=a.getPhoneNumber() %></td>
                                </tr>   
                                <tr>
                                	<td></td>
                                	<td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                	<td></td>
                                	<td></td>
                                    <td><%=a.getCareer() %></td>
                                </tr>
                                <tr>
                                	<td style="width:200px;"><%=a.getSaveDate() %></td>
                                	<td></td>
                                	<td></td>
								    
								</tr>
							</table>
							</td>
						</tr>
						<tr>
							<td class="btn_position" colspan="2">
								<div class="btn_pos">
 								<input type = "hidden" name = "card_number" value ='<%=a.getCardNumber() %>'>
 								<input type = "hidden" name = "org_number" value='<%=a.getOrgNumber() %>'>
								<input type = "submit" class="btn_remove" name = "btn" value = "삭제">
								<input type = "submit" class="btn_update" name = "btn" value = "수정">
								</div>
							</td>
						</tr>
					
						<%		}
							else{
								System.out.println("null값입니다.");
							}
						count++;
						}
					if(count==0){
						%>
						<tr><td colspan="7">저장한 명함이 없습니다.</td></tr>		
					<%
					}
					%>	
					</form>
					<tr>
						<td colspan="2">
							<form action="org_info" method="POST" class="btn_card">
								<input type ="hidden" name="user_id" value='${ id }' >
								<input type="submit" class="create_card" name="btn" value="명함 생성">	
							</form>	
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	
	
</body>
</html>