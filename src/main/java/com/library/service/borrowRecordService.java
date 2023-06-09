package com.library.service;

import com.library.mapper.bookMapper;
import com.library.mapper.borrowRecordMapper;
import com.library.pojo.Book;
import com.library.pojo.borrowRecord;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class borrowRecordService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<borrowRecord> selectAllRecord(int uno){
        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        borrowRecordMapper mapper = sqlSession.getMapper(borrowRecordMapper.class);

        //4.调用方法
        List<borrowRecord> books=mapper.selectAllRecord(uno);
        sqlSession.close();

        return books;
    };
}
