package com.wuzhixin.domain;
/**
 * ����һ��bookbean �ֶκ� ���ݿ��еı���ȫ��Ӧ
 * @author ��־��
 *
 */

public class BookBean {
	private int id;
	private String bookname;
	private String author;
	private String pulishHouse;
	private float price=0f;
	private int number; //��Ŀ������
	private int shoppingnum=1; //�����ʼ�� ���������Ϊ 1
	
	
	
	public int getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(int shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPulishHouse() {
		return pulishHouse;
	}
	public void setPulishHouse(String pulishHouse) {
		this.pulishHouse = pulishHouse;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
