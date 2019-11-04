package com.wuzhixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuzhixin.domain.BookBean;
import com.wuzhixin.domain.UserBean;
import com.wuzhixin.service.BookService;
import com.wuzhixin.service.MyCart;
import com.wuzhixin.service.UserService;

public class GoHallUI extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		if(user!=null){
			BookService bookService=new BookService();
			ArrayList <BookBean> bookList = bookService.getAllBook();
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			return;
		}
		
		//得到从登陆页面传递的用户名 密码
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		 user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		UserService userService = new UserService();
		boolean b = userService.checkUser(user);
		if(b){
			//跳转之前先给要跳转的 页面准备数据
			//登陆成功后创建一个购物车 并把购物车放入session中
			MyCart cart = new MyCart();
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("user", user);
			
			BookService bookService=new BookService();
			ArrayList <BookBean> bookList = bookService.getAllBook();
			request.setAttribute("bookList", bookList);
			
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		}
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
