<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登陆界面</h1>
	<form action="/mycart2/GoHallUI" method="post">
		<table border=1 bordercolor="blue">
		
		<tr> <td>用户名：</td> <td><input type="text" name="username">  </td></tr>
		<tr> <td>密　码: </td> <td><input type="password" name="password" ></td></tr>
		
		
		</table>
		<input type="submit" value="登陆"> <input type="reset" value="重新输入">
	</form>

</body>
</html>