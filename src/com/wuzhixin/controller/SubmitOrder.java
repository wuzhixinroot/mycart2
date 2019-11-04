package com.wuzhixin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuzhixin.domain.UserBean;
import com.wuzhixin.service.MyCart;
import com.wuzhixin.service.OrderService;

import java.io.PrintWriter;

public class SubmitOrder extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//��servletҪ�����¶��� ��ҵ��
		// ���͵����ʼ����ͻ������� ������ д�����ݿ�
		
		
		try {
			MyCart cart = (MyCart) request.getSession().getAttribute("cart");
			UserBean user = (UserBean) request.getSession().getAttribute("user");
			OrderService os = new OrderService();
			System.out.println(user.getId());
			os.submitOrder(cart, user);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/WEB-INF/Err.jsp");
		}
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/OrderFinish.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
