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
<link rel="stylesheet" href="css/joinstyle.css">
<link rel="stylesheet" href="css/default2.css">
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
	
	<form method="post" action="join">
            <div class = "box_join">
                <section class="join">
                    <h3>회원가입</h3>
                </section>
                <div class = "input_text">
                    <input type="text" id="UserName" name="UserName" placeholder="이름">
                </div>
                <div class = "input_text">
                    <input type="text" id="UserID" name="UserID" placeholder="ID">
                </div>
                <div class = "input_text">
                    <input type="password" id="UserPW" name="UserPW" placeholder="Password">
                </div>
                <div class = "input_text">
                    <input type="email" id="UserEmail" name="UserEmail" placeholder="Email">
                </div>
                <input type="submit" class="btn_join" value="회원가입">
            </div>
        </form>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
</body>
</html>