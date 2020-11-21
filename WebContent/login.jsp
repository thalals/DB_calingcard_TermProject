<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<!-- 부트스트랩 사용하기 위해 링크 -->
<link rel="stylesheet" href="css/loginstyle.css">
<link rel="stylesheet" href="css/default2.css">
<title>login 페이지</title>
</head>
<body>
	<form method="post" action="login" class="login_form">
            <div class = "box_login">
                <section class="login">
                    <h2>로그인</h2>
                </section>
                <div class = "input_text">
                    <input type="text" id="UserID" name="UserID" placeholder="ID">
                </div>
                <div class = "input_text">
                    <input type="password" id="UserPW" name="UserPW" placeholder="Password">
                </div>
                <center>
                <input type="submit" class="btn_login" value="로그인">
                </center>
            </div>
        </form>
</body>
</html>