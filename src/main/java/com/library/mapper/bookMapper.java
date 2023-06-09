package com.library.mapper;

import com.library.pojo.Book;
import com.library.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface bookMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("SELECT bno,bname,wri,ssort,pub,inq\n" +
            "FROM book,sort\n" +
            "WHERE book.sno=sort.sno; \n")
    List<Book> selectBook();


    /**
     * 查看简介
     * @param bno
     * @return
     */

    @Select("SELECT intro\n" +
            "FROM book\n" +
            "WHERE bno=#{bno};\n")
    String showDetail(int bno);

    /**
     * 借阅
     */
    @Update("UPDATE book\n" +
            "SET inq=inq-1\n" +
            "WHERE bno=#{bno};\n")
    void lend(int bno);


    /**
     * 查询
     */
    @Select("SELECT *\n" +
            "FROM book\n" +
            "WHERE bno=#{bno};\n")
    List<Book> query(int bno);

    /**
     * 查询书籍
     * @return
     **//*
    @Select("select * from book")
    List<Book> selectBooks();*/
    /**
     *根据书名查找
     * @return
     * @param
     * */
    @Select("select * from book where bname=#{bname} ")
    List<Book> selectBookbybname(@Param("bname") String bname);
    /**
     * 根据书籍编号查找
     * @return
     * */
    @Select("select * from book where bno = # {bno} ")
    List<Book> selectBookbybno(@Param("bno") int bno);


    //inq是库存
    //intro是简介

    /**
     * 添加书籍
     */
    @Insert("INSERT INTO book\n" +
           /* "VALUES(null,#{bname},#{sno},#{wirter},#{pub},#{pdate},#{booknum},#{intro})")*/
            "VALUES(null,#{bname},null,#{wirter},#{pub},null,#{booknum},#{intro})")
    void addBook(Book book);


    /**
     * 删除书籍
     */
    @Delete("DELETE FROM book\n" +
            "WHERE bno=#{bno};")
    void deleteBook();



}
