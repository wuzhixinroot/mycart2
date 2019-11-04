<%@ page language="java" contentType="text/html; charset=UTF-8 " import="java.util.ArrayList"
	pageEncoding="UTF-8" import="com.wuzhixin.domain.BookBean,com.wuzhixin.service.MyCart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="/mycart2/css/main.css" rel="stylesheet" >
</head>
<body>
	<h1>我的购物车</h1>
	<a href="/mycart2/GoHallUI">返回购物大厅</a>
	<form action="/mycart2/ShoppingCl?type=update" method="post">
		<table border=1>

			<tr>
				<td>BookID</td>
				<td>书名</td>
				<td>价格</td>
				<td>出版社</td>
				<td>数量</td>
				<td>是否删除</td>
			</tr>
			<%
				MyCart  myCart=(MyCart) request.getSession().getAttribute("cart");
				ArrayList books = myCart.showMyCart();
				for(int i = 0 ;i<books.size();i++)
				{ BookBean book =(BookBean) books.get(i);
			%>
			<tr>
				<td><%=book.getId() %><input type="hidden" name="bookid" value="<%=book.getId() %>"></td>
				<td><%=book.getBookname() %></td>
				<td><%=book.getPrice() %></td>
				<td><%=book.getPulishHouse() %></td>
				<td><input type="text" name="booknumber"  value="<%=book.getShoppingnum()%>"></td>
				<td><a href="/mycart2/ShoppingCl?id=<%=book.getId() %>&type=delete">删除</a></td>
			</tr>
			<%
				}
				
			%>
			<tr>
				<td colspan="6">购物车总价格：${totalPrice} </td>

			</tr>

			<tr>
				<td colspan="6"><input type="submit" value="更新"></td>

			</tr>

			
		</table>
	</form>
	<br>
	<br>
	
	<a href="/mycart2/ShoppingCl?type=clear">清空购物车</a> &nbsp; &nbsp; &nbsp;
	<a href="/mycart2/OrderCl">提交订单</a>

</body>
</html>