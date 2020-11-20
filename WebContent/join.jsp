<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/joinstyle.css">
<link rel="stylesheet" href="css/default2.css">
<title>join 페이지</title>
</head>
<body>
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
</body>
</html>