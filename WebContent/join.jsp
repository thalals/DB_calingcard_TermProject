<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li> <a href="main.jsp">메인</a></li>
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
				<section id="joinformArea">
					<form action="join" method="POST">
						<h3 style="text-align: center;">회원가입 화면</h3>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="이름" name="UserName" id="UserName" maxlength="20">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="아이디" name="UserID" id="UserID" maxlength="20">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="비밀번호" name="UserPW" id="UserPW" maxlength="20">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="이메일" name="UserEmail" id="UserEmail" maxlength="20">
						</div>
						
						<input type="submit" class="btn btn-primary form-control" value="회원가입">	
						
						</form>	
				</section>
			</div>
		</div>
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
</body>
</html>