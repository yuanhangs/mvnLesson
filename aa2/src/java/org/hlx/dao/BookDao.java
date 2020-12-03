package org.hlx.dao;

import org.hlx.entity.Book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


public class BookDao {
	// 使用map集合来模拟数据库
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static {
		books.put("1", new Book("1", "《水浒传》", "施耐庵", 48));
		books.put("2", new Book("2", "《西游记》", "吴承恩 ", 58));
		books.put("3", new Book("3", "《三国演义》", "罗贯中", 78));
		books.put("4", new Book("4", "《红楼梦》", "曹雪芹", 28));
		books.put("5", new Book("5", "《平凡的世界》", "路遥", 18));
	}
	
	/**
	 *  获得所有图书
	 * @return
	 */
	public static Collection<Book> getAll(){
		return books.values();
	}
	
	/**
	 *   根据id查找图书
	 * @param key
	 * @return
	 */
	public static Book getBook(String key){
		return books.get(key);
	}

}
