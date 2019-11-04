package com.wuzhixin.service;

import java.util.ArrayList;

import com.wuzhixin.domain.UserBean;
import com.wuzhixin.util.SqlHelper;

/**
 * 专门处理业务逻辑的service
 * @author 吴志新
 * 处理和uesr表相关的业务逻辑
 *
 */

public class UserService {
	
	//验证用户是否合法的方法  从数据库中取得一个对象集合，合法 就把对象数组 重新封装到 user对象中 
	
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
