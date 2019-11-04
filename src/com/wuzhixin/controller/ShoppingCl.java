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
 * �ÿ�����������Ӧ�û�������Ʒ������ ���� ɾ�� ���޸���Ϊ
 * @author ��־��
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
		 * �����û�Ҫ����ʲô������Ҫ ���� type id  ���Թ��ﳵ���в���
		 */
		
		String type = (String)request.getParameter("type");
		String id = request.getParameter("id");
		MyCart myCart = new MyCart();
		myCart = (MyCart) request.getSession().getAttribute("cart");
		
		if(type.equals("add")){   //��� ��Ʒ  
		
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
//		request.setAttribute("books", books);         �ѹ��ﳵ�е���Ʒȡ����
		//׼�����¸�ҳ��ʹ�ã���ʱ��Ʒ���� session �� Ҳ�ɲ�ȡ ֱ�� �� showmycart ҳ����
		// ��session ��ȡ����
		
		//׼���� �ܼ�
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
