package com.library.service;

import com.library.mapper.bookMapper;
import com.library.pojo.Book;

import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class bookService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有书籍
     * @return
     */
    public List<Book> selectAllBook(){
        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();

        bookMapper mapper = sqlSession.getMapper(bookMapper.class);

        //4.调用方法
        List<Book> books=mapper.selectBook();
        sqlSession.close();

        return books;
    }

    /**
     * 据输入内容查找
     * @param input
     * @return
     */

    public List<Book> selectBookByInput(String input){

        SqlSession sqlSession=factory.openSession();

        bookMapper bookMapper = sqlSession.getMapper(bookMapper.class);

        List<Book> bookList = new ArrayList<>();
        try{
            //尝试将输入内容解析为数字
            int bno = Integer.parseInt(input);
            List<Book> bookListbyBno = bookMapper.selectBookbybno(bno);
            if (bookListbyBno.size()>0){
                bookList.addAll(bookListbyBno);
            }
            else {
                // 弹出提示框，提示书籍不存在
                JOptionPane.showMessageDialog(null, "书籍不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            }
        }catch (NumberFormatException e){
            //解析为数字失败
            List<Book> bookListbyBname = bookMapper.selectBookbybname(input);
            if(bookListbyBname.size()>0){
                bookList.addAll(bookListbyBname);
            }else {
                // 弹出提示框，提示书籍不存在
                JOptionPane.showMessageDialog(null, "书籍不存在！", "提示", JOptionPane.ERROR_MESSAGE);
            }

        }
        return bookList;
    }

    /**
     * 添加书籍
     * @param book
     */
    public void addBook(Book book){
        SqlSession sqlSession=factory.openSession();

        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        mapper.addBook(book);
        sqlSession.commit();
        sqlSession.close();

    }



    public String detail(int bno){
        //接收参数

        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        String book = mapper.showDetail(bno);
        System.out.println(book);
        sqlSession.close();

        //4.调用方法
         return book;
    };
    public void lend(int bno){
        SqlSession sqlSession=factory.openSession();

        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        mapper.lend(bno);

        sqlSession.commit();
        sqlSession.close();

    }

    public List<Book> query(String param){
        //调用BrandMapper.selectAll()
        int bno=Integer.parseInt(param);
        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);

        //4.调用方法
        List<Book> books=mapper.query(bno);
        sqlSession.close();

        return books;
    };


}
