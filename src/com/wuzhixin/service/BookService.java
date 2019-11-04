package com.wuzhixin.service;

import java.util.ArrayList;

import com.wuzhixin.domain.BookBean;
import com.wuzhixin.util.SqlHelper;

/**
 * ����bookҵ���߼��࣬�����book��ص�ҵ��
 * 
 * @author ��־��
 *
 */

public class BookService {
	// �õ����е��鼮��Ϣ
	// ����ɷ�ҳ��������ҳ�� ��
	// ͨ�������� �ĵ��õõ� ���� ���� ���ݸ� ������� ҳ��

	// �õ����е��鼮
	public ArrayList<BookBean> getAllBook() {
		String sql = "select * from book where 1=?";
		String parameters[] = { "1" };
		ArrayList bookList = SqlHelper.executeQuery2(sql, parameters);
		ArrayList<BookBean> newBookList = new ArrayList<BookBean>();
		for (int i = 0; i < bookList.size(); i++) {
			Object[] object = (Object[]) bookList.get(i);
			BookBean bookBean = new BookBean();
			bookBean.setId(Integer.parseInt(object[0].toString()));
			bookBean.setBookname((String) object[1]);
			bookBean.setAuthor((String) object[2]);
			bookBean.setPulishHouse((String) object[3]);
			bookBean.setPrice(Float.parseFloat(object[4].toString()));
			bookBean.setNumber(Integer.parseInt((String) object[5].toString()));
			newBookList.add(bookBean);

		}

		return newBookList;
	}

	// ͨ��id ���� ��Ʒ����
	public BookBean getBookBeanById(String id) {
		String sql = "select * from book where id =?";
		String parameters[] = { id };
		ArrayList book = SqlHelper.executeQuery2(sql, parameters);
		BookBean bookBean = new BookBean();
		if (book.size() == 1) {
			Object[] object = (Object[]) book.get(0);
			bookBean.setId(Integer.parseInt(object[0].toString()));
			bookBean.setBookname((String) object[1]);
			bookBean.setAuthor((String) object[2]);
			bookBean.setPulishHouse((String) object[3]);
			bookBean.setPrice(Float.parseFloat(object[4].toString()));
			bookBean.setNumber(Integer.parseInt((String) object[5].toString()));
			bookBean.setShoppingnum(1);
		
		}

		return bookBean;
	}

	// �õ��鼮��ҳ��

}
