package com.library.service;

import com.library.mapper.bookMapper;
import com.library.mapper.borrowRecordMapper;
import com.library.mapper.returnMapper;
import com.library.pojo.borrowRecord;
import com.library.pojo.returnRecord;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class returnRecordService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<returnRecord> selectAllRecord(int uno){
        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        returnMapper mapper = sqlSession.getMapper(returnMapper.class);

        //4.调用方法
        List<returnRecord> books=mapper.selectReturnBook(uno);
        sqlSession.close();

        return books;
    };
    public void returnBook(int bno){
        SqlSession sqlSession=factory.openSession();

        returnMapper mapper = sqlSession.getMapper(returnMapper.class);
        mapper.returnBook(bno);

        sqlSession.commit();
        sqlSession.close();

    }
}
