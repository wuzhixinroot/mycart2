package com.wuzhixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.wuzhixin.domain.BookBean;

/**
 * 进行购物车 的操作，购物车的数据不一样，而且一直都在随着用户的需要 而变动
 * 因此 不能做成数据库表  ，通过函数来操作购物车
 * @author 吴志新
 *
 */

public class MyCart {
	HashMap<String ,BookBean> hashMap = new HashMap<String,BookBean>();
	
	//添加书
	public void addBook(String id ,BookBean book){
		
		if(hashMap.containsKey(id)){
			BookBean book1 = hashMap.get(id);
			int shoppingnum = book1.getShoppingnum()+1;
			book1.setShoppingnum(shoppingnum);
			System.out.println(shoppingnum);
			hashMap.put(id, book1);
		}else{
			hashMap.put(id, book);
			System.out.println("xxxx");
		}
	}
	
	//添加书2
	public void addBook2(String id){
		if(hashMap.containsKey(id)){
			BookBean book = hashMap.get(id);
			int shoppingnum = book.getShoppingnum()+1;
			book.setShoppingnum(shoppingnum);
			
		}else{
			hashMap.put(id, new BookService().getBookBeanById(id));
		}
	}
	//返回该购物车的总价格
	//
	public float getTotalPrice(){
		Iterator bookskey = hashMap.keySet().iterator();
		float totalPrice = 0f;
		while(bookskey.hasNext()){
			String id = (String) bookskey.next();
			BookBean book = hashMap.get(id);
			float price = book.getPrice();
			int number = book.getShoppingnum();
			totalPrice = totalPrice +number*price;
			
		}
		System.out.println(totalPrice);
		
		return totalPrice;
		
	}
	
	//删除书
	public void deleteBook(String id){
		BookBean book = hashMap.get(id);
		if(book.getShoppingnum()==1){
			hashMap.remove(id);
		}else if(book.getShoppingnum()>1){
			int num = book.getShoppingnum()-1;
			book.setShoppingnum(num);
			
		}
	}
	
	//更新书
	public void updateBook(String bookid[] ,String booknumbers[]){
		for(int i = 0;i<bookid.length;i++){
			BookBean book =hashMap.get(bookid[i]);
			book.setShoppingnum(Integer.parseInt(booknumbers[i]));
		}
		
	}
	
	//显示该购物车中的所有商品信息 遍历 hashmap 用迭代器首先得到所有key
	public ArrayList<BookBean> showMyCart(){
		//遍历hashmap
		ArrayList books = new ArrayList<>();
		
		Iterator iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String id = (String) iterator.next();
			BookBean bookBean = hashMap.get(id);
			books.add(bookBean);
		}
		
		return books;
	}
	
	//清空购物车 删除所有书
	public void clearBook(){
		hashMap.clear();
	}
	
	

}
