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
	// �¶���������ű� һ���� ������һ���Ƕ�������������ű�ͨ�� ��Ʒ��� ��ϵ
	public void submitOrder(MyCart cart ,UserBean user){ 
		String sql = "insert into orderform (username,order_time, order_price) values(?,now(),?) ";
		
//		conn=SqlHelper.getConn();
//		System.out.println("ddddddddddddd");
		try {
			conn=SqlHelper.getConnection();//����
			
			System.out.println("ddddddddddddddddd");
			conn.setAutoCommit(false);//�����Զ��ύ����Ϊ�����ύ
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//��������Ϊ��߼���
			System.out.println("eeeeeeeeeeeeee");
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,user.getUsername());
			ps.setFloat(2, cart.getTotalPrice());
			ps.executeUpdate();            
			
			sql="select last_insert_id() from orderform"; //��ѯ�����������id
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
