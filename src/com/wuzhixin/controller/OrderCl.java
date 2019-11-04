package com.wuzhixin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuzhixin.domain.UserBean;
import com.wuzhixin.service.MyCart;


public class OrderCl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		Enumeration<String> name =request.getSession().getAttributeNames();
//		while(name.hasMoreElements()){
//			System.out.println(name.nextElement());
//		}
		/**
		 * �������ﳵ������session ���� ���Բ���Ҫ׼������ ֱ�� �� myorder��ҳ����ȡ����
		 * ���� ҲҪ��������� 
		 */
		
		MyCart cart = (MyCart) request.getSession().getAttribute("cart");
		
		//��ȡsession���ﳵ ���� ׼����ʾ
		
		ArrayList books = cart.showMyCart();
		float totalPrice = cart.getTotalPrice();
		
		//�����ݷ��� request����
		request.setAttribute("booksinfo", books);
		request.setAttribute("totalPrice", totalPrice);
		
		request.getRequestDispatcher("/WEB-INF/MyOrder.jsp").forward(request, response);
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
