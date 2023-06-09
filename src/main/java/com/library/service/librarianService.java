package com.library.service;

import com.library.mapper.LibrarianMapper;
import com.library.pojo.Librarian;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class librarianService {

    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有图书管理员
     * @return
     * */
    public List<Librarian> selectAllLibrarian(){

       SqlSession sqlSession =  factory.openSession();

       LibrarianMapper librarianMapper = sqlSession.getMapper(LibrarianMapper.class);
       //调用方法
       List<Librarian> librarians = librarianMapper.selectAllLibrarian();

       //释放资源
       sqlSession.close();

       return librarians;
    }

    /**
     * 根据输入参数查询图书管理员
     * @param input
     * @return
     */
    public List<Librarian> selectLibrarianByInput(String input) {
        SqlSession sqlSession =  factory.openSession();
        LibrarianMapper librarianMapper = sqlSession.getMapper(LibrarianMapper.class);
        //调用方法
        List<Librarian> librarianList = librarianMapper.selectLibrarianByMName(input);
        int i = Integer.parseInt(input);
        librarianList.add((Librarian) librarianMapper.selectLibrarianByMno(i));
        //释放资源
        sqlSession.close();

        return librarianList;
    }

    /**
     * 添加图书管理员
     * @param librarian
     */
    public void addLibrarian(Librarian librarian){
        SqlSession sqlSession =  factory.openSession();
        LibrarianMapper librarianMapper = sqlSession.getMapper(LibrarianMapper.class);
        librarianMapper.addLibrarian(librarian);
        sqlSession.commit();
        sqlSession.close();

    }

/*
    public Librarian librarianlogin(String mname, String mpassword){
        SqlSession sqlSession=factory.openSession();
        LibrarianMapper librarianMapper=sqlSession.getMapper(LibrarianMapper.class);
        Librarian librarian = librarianMapper.selectLibrarian(mname, mpassword);
        sqlSession.close();
        return librarian;
    }*/



}
