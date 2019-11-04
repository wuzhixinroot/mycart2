package com.wuzhixin.service;

import java.util.ArrayList;

import com.wuzhixin.domain.UserBean;
import com.wuzhixin.util.SqlHelper;

/**
 * ר�Ŵ���ҵ���߼���service
 * @author ��־��
 * �����uesr����ص�ҵ���߼�
 *
 */

public class UserService {
	
	//��֤�û��Ƿ�Ϸ��ķ���  �����ݿ���ȡ��һ�����󼯺ϣ��Ϸ� �ͰѶ������� ���·�װ�� user������ 
	
	public boolean checkUser(UserBean user){
		String sql = "select * from user where username =? and password=?";
		String parameters[]={user.getUsername(),user.getPassword()};
		ArrayList userList = SqlHelper.executeQuery2(sql, parameters);
		if(userList.size()==0){
			return false;
		}else{
			Object [] object = (Object[]) userList.get(0);
			user.setUsername((String)object[1]);
			user.setEmail((String)object[3]);
			user.setGrade(Integer.parseInt(object[5].toString()));
			return true;
		}
	}
	
	

}
