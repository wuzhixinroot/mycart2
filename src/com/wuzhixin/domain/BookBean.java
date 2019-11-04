package com.wuzhixin.domain;
/**
 * 这是一个bookbean 字段和 数据库中的表完全对应
 * @author 吴志新
 *
 */

public class BookBean {
	private int id;
	private String bookname;
	private String author;
	private String pulishHouse;
	private float price=0f;
	private int number; //书的库存数量
	private int shoppingnum=1; //给书初始化 购买的数量为 1
	
	
	
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
