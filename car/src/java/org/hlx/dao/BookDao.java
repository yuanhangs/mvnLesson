package org.hlx.dao;

import org.hlx.entity.Book;
import org.hlx.util.BaseDao;

import java.util.*;

public class BookDao extends BaseDao {

    //1.实例化map对象（key,value)
   private Map<Integer, Book> books = new LinkedHashMap<Integer, Book>();
    /**
     * 获取所有的数据
     * @return
     */
    public  Map<Integer, Book>  all(){
        //2.sql语句
        String sql="select * from book";

        //3.调用方法
        try {
            List<Book> list=this.excuteMoreQuery(sql,Book.class);

            //4.遍历数据
            for(Book book:list){
                books.put(book.getId(),book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return books;
    }


    /**
     * 获取所有的书
     * @return
     */
    public Collection<Book> getBooks( Map<Integer, Book> books){
        return books.values();
    }


    /**
     * 通过key找到书
     * @param key
     * @return
     */
    public Book getBook( Map<Integer, Book> books,Integer key){
        return books.get(key);
    }


}


//class Test{
//    public static void main(String[] args) {
//        Map<Integer, Book> map= new BookDao().all();
//       Set<Integer> keys= map.keySet();
//       for(Integer key:keys){
//           System.out.println(key+"="+map.get(key));
//       }
//    }
//}