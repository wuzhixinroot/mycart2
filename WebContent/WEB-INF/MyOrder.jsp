<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.wuzhixin.domain.*,
    com.wuzhixin.service.MyCart,java.util.ArrayList,
    java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gotoSubmitOrder(){
		window.location.href="/mycart2/SubmitOrder";
		
	}
	



</script>
</head>
<body>
	<%
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		ArrayList books = (ArrayList) request.getAttribute("booksinfo");
	%>
	<a href="???????">安全退出</a> &nbsp; &nbsp; &nbsp;|
	<a href="/mycart2/GoHallUI">返回购物大厅</a>
	<h1>我的订单</h1>

	<h2>我的订单信息</h2>
	
		<table border=1>
			<tr>
				<th colspan="2">我的个人信息</th>
			</tr>
			<tr>
				<td>用户名</td>
				<td><%=user.getUsername()%></td>
			</tr>
			<tr>
				<td>电子邮件</td>
				<td><%=user.getEmail()%></td>
			</tr>
			<tr>
				<td>用户级别</td>
				<td><%=user.getGrade()%></td>
			</tr>

		</table>
		<br> <br>
		<hr>
		<table border="1px" bordercolor="red">
			<tr>
				<th>BookID</th>
				<th>书名</th>
				<th>价格</th>
				<th>出版社</th>
				<th>数量</th>
			</tr>
			<%
				Iterator iterator = books.iterator();
				while (iterator.hasNext()) {
					BookBean book = (BookBean) iterator.next();
			%>

			<tr>
				<td><%=book.getId()%></td>
				<td><%=book.getBookname()%></td>
				<td><%=book.getPrice()%></td>
				<td><%=book.getPulishHouse()%></td>
				<td><%=book.getShoppingnum()%></td>
			</tr>

			<%
				}
			%>

			<tr>
				<th colspan="5">购物车总价格为 ${totalPrice }</th>
			</tr>
		</table>
		
		<input type="button"  onclick="gotoSubmitOrder()" value="确认提交">

	



</body>
</html>