package com.wuzhixin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuzhixin.service.MyCart;

import java.io.PrintWriter;


public class ShoppingClSendRedirect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MyCart myCart = (MyCart) request.getSession().getAttribute("cart");
		
		String type = request.getParameter("type");
		System.out.println(type);
		if(type.equals("add")){
			 request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
			 request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
		}
		
		if(type.equals("delete")){
			 request.setAttribute("totalPrice", myCart.getTotalPrice()+"");
			 request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);
		}
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
