package com.wuzhixin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wuzhixin.domain.BookBean;
import com.wuzhixin.domain.UserBean;
import com.wuzhixin.util.SqlHelper;

public class OrderService {
		private Connection conn=null;
		private PreparedStatement ps = null;
		private ResultSet rs =null;
	// 下订单设计两张表 一张是 订单表，一张是订单详情表这两张表通过 商品编号 联系
	public void submitOrder(MyCart cart ,UserBean user){ 
		String sql = "insert into orderform (username,order_time, order_price) values(?,now(),?) ";
		
//		conn=SqlHelper.getConn();
//		System.out.println("ddddddddddddd");
		try {
			conn=SqlHelper.getConnection();//好了
			
			System.out.println("ddddddddddddddddd");
			conn.setAutoCommit(false);//不能自动提交，设为整体提交
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//将事物设为最高级别
			System.out.println("eeeeeeeeeeeeee");
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,user.getUsername());
			ps.setFloat(2, cart.getTotalPrice());
			ps.executeUpdate();            
			
			sql="select last_insert_id() from orderform"; //查询到插入后语句的id
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int OrderId = 0;
			if(rs.next()){
				OrderId = rs.getInt(1);
			}
			
			ArrayList<BookBean> books = cart.showMyCart();
			for(int i = 0 ;i<books.size();i++){
				String sql2 = "insert into orderdetail (shopping_id,shopping_name,"
						+ "shopping_number,order_detail_id) values(?,?,?,?)";
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, books.get(i).getId());
				ps.setString(2, books.get(i).getBookname());
				ps.setInt(3, books.get(i).getShoppingnum());
				ps.setInt(4, OrderId);
			
				ps.executeUpdate();
			}
			
			conn.commit();
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage());
			}
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, ps, conn);
		}
		
		
	}

}
