package com.wuzhixin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuzhixin.domain.BookBean;
import com.wuzhixin.service.BookService;
import com.wuzhixin.service.MyCart;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 该控制器用于响应用户购买商品的请求 增加 删除 ，修改行为
 * @author 吴志新
 *
 */

public class ShoppingCl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		/**
		 * 不论用户要进行什么操作都要 传入 type id  并对购物车进行操作
		 */
		
		String type = (String)request.getParameter("type");
		String id = request.getParameter("id");
		MyCart myCart = new MyCart();
		myCart = (MyCart) request.getSession().getAttribute("cart");
		
		if(type.equals("add")){   //添加 商品  
		
		BookService bookService = new BookService();
		myCart.addBook2(id);
		response.sendRedirect("/mycart2/ShoppingClSendRedirect?type=add");
//        request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
//		request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
		
		
		}else if(type.equals("delete")){
			myCart.deleteBook(id);
			response.sendRedirect("/mycart2/ShoppingClSendRedirect?type=delete");
//			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
//			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);;
			
		}else if(type.equals("update")){
	
			String bookids[] =request.getParameterValues("bookid");
			String booknumbers[]=request.getParameterValues("booknumber");
			myCart.updateBook(bookids, booknumbers);
			response.sendRedirect("/mycart2/ShoppingClSendRedirect");
//			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
//			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);;
		}else if(type.equals("clear")){
			myCart.clearBook();
			response.sendRedirect("/mycart2/ShoppingClSendRedirect");
//			request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
//			request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);;
		}
		
		
		
		
//		ArrayList books = myCart.showMyCart();
//		request.setAttribute("books", books);         把购物车中的商品取出来
		//准备给下个页面使用，此时商品是在 session 中 也可不取 直接 到 showmycart 页面中
		// 在session 中取出来
		
		//准备好 总价
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
