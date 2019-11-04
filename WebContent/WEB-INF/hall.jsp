<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList,com.wuzhixin.domain.BookBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎光临购物大厅</h1>
	<table border=1>
		<tr>
			<th>书名</th>
			<th>价格</th>
			<th>出版社</th>
			<th>点击购买</th>
		</tr>
		<%
			ArrayList<BookBean> books = (ArrayList<BookBean>) request.getAttribute("bookList");
			for (int i = 0; i < books.size(); i++) {
				BookBean book = books.get(i);
		%>

		<tr>
			<td><%=book.getBookname()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getPulishHouse()%></td>
			<td><a href="/mycart2/ShoppingCl?id=<%=book.getId()%>&type=add">点击购买</a></td>
		</tr>

		<%
			}
		%>

		<tr>
			<td colspan="4"><input type="button" value="查看购物车"></td>
		</tr>


	</table>
	<a href="/mycart2/index.jsp">返回重新登陆</a>

</body>
</html>