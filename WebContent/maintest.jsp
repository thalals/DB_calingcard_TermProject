<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.CardDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<jsp:useBean id="card" class="vo.Card" scope="page" />
<jsp:setProperty name="card" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<!-- 부트스트랩 사용하기 위해 링크 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<title>login 페이지</title>
</head>
<body>
	<!-- nav는 페이지의 전체적인 구성을 보여줌 -->
	<nav class="navbar navbar-default">
	<!-- 헤더 부분 -->
		<div class = "navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<!-- 화면의 너비를 줄였을때 나오는 메뉴버튼의 작대기 수 - span -->
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>	
				<span class="icon-bar"></span>		
			</button>
			<a class="navbar-brand" href="main.jsp">명함 관리 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<!-- 하나의 리스트를 보여줄 떄 사용 -->
			<ul class="nav navbar-nav">
				<li> <a href="maintest.jsp">메인</a></li>
				<li> <a href="bbs.jsp">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li> 
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="clo-lg-4"></div>
		<div class="clo-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="post" action="">
					<h3 style="text-align: center;">명함 한눈에 보기</h3>
					<%
						Connection conn=null;
						String sql="select * from card";
						PreparedStatement ps = null;	//sql문 실행을 위한 객체
						ResultSet rs=null;
						try {
							//mysql 접속 url
							String url = "jdbc:mysql://localhost:3306/detol?serverTimezone=UTC";
							String id = "root";
							String password ="1234";
							Class.forName("com.mysql.cj.jdbc.Driver");	//mysql 드라이버 찾기
							conn = DriverManager.getConnection(url,"root","1234"); //conn객체 안에 접속정보
							ps=conn.prepareStatement(sql);
							rs=ps.executeQuery();
					%>
					<%	while(rs.next()){ %>
						<table>
							<tr>
								<td><%=rs.getString("Name") %></td>
								<td width = 100px></td>
								<td><a href="deleteCard.jsp?CardNumber=<%=rs.getInt("CardNumber") %>">삭제</a></td>
							</tr>
						</table>
					<%	} %>
					<%
						}catch(Exception e) {
							e.printStackTrace(); //오류 출력
						}
					%>
					
					
					<input type="submit" class="btn btn-primary form-control" value="명함 생성">	
				</form>	
			</div>
		</div>
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
</body>
</html>