package com.wuzhixin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.wuzhixin.domain.BookBean;

/**
 * ���й��ﳵ �Ĳ��������ﳵ�����ݲ�һ��������һֱ���������û�����Ҫ ���䶯
 * ��� �����������ݿ��  ��ͨ���������������ﳵ
 * @author ��־��
 *
 */

public class MyCart {
	HashMap<String ,BookBean> hashMap = new HashMap<String,BookBean>();
	
	//�����
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
	
	//�����2
	public void addBook2(String id){
		if(hashMap.containsKey(id)){
			BookBean book = hashMap.get(id);
			int shoppingnum = book.getShoppingnum()+1;
			book.setShoppingnum(shoppingnum);
			
		}else{
			hashMap.put(id, new BookService().getBookBeanById(id));
		}
	}
	//���ظù��ﳵ���ܼ۸�
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
	
	//ɾ����
	public void deleteBook(String id){
		BookBean book = hashMap.get(id);
		if(book.getShoppingnum()==1){
			hashMap.remove(id);
		}else if(book.getShoppingnum()>1){
			int num = book.getShoppingnum()-1;
			book.setShoppingnum(num);
			
		}
	}
	
	//������
	public void updateBook(String bookid[] ,String booknumbers[]){
		for(int i = 0;i<bookid.length;i++){
			BookBean book =hashMap.get(bookid[i]);
			book.setShoppingnum(Integer.parseInt(booknumbers[i]));
		}
		
	}
	
	//��ʾ�ù��ﳵ�е�������Ʒ��Ϣ ���� hashmap �õ��������ȵõ�����key
	public ArrayList<BookBean> showMyCart(){
		//����hashmap
		ArrayList books = new ArrayList<>();
		
		Iterator iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String id = (String) iterator.next();
			BookBean bookBean = hashMap.get(id);
			books.add(bookBean);
		}
		
		return books;
	}
	
	//��չ��ﳵ ɾ��������
	public void clearBook(){
		hashMap.clear();
	}
	
	

}
