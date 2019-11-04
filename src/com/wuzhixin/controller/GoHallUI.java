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
		
		//�õ��ӵ�½ҳ�洫�ݵ��û��� ����
		
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
			//��ת֮ǰ�ȸ�Ҫ��ת�� ҳ��׼������
			//��½�ɹ��󴴽�һ�����ﳵ ���ѹ��ﳵ����session��
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
