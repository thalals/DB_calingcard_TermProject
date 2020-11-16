<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="org_info" method="POST">
		<table>
			<tr>
				<td>
					<select name="choice">
					  <option value="first">First Value</option>
					  <option value="second" selected>Second Value</option>
					  <option value="third">Third Value</option>
					</select>
				</td>
				<td>
					<input type="submit" value="추가" name="btn">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="다음" name="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>