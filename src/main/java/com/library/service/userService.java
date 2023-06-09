package com.library.service;

import com.library.mapper.LibrarianMapper;
import com.library.mapper.UserMapper;
import com.library.mapper.bookMapper;
import com.library.pojo.Librarian;
import com.library.pojo.User;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
public class userService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有用户
     * @return
     * */
    public List<User> selectAllusers(){

        SqlSession sqlSession =  factory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> users = userMapper.selectAllusers();

        //释放资源
        sqlSession.close();

        return users;

    }

    public User selectUserByuno(int uno){
        SqlSession sqlSession =  factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByUno(uno);
        return user;
    }

    /**
     * 根据输入参数查询用户
     * @param input
     * @return
     */
    public List<User> selectUserbyinput(String input) {
        SqlSession sqlSession =  factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        List<User> users = userMapper.selectUserByUName(input);
        int i = Integer.parseInt(input);
        users.add((User) userMapper.selectUserByUno(i));
        //释放资源
        sqlSession.close();

        return users;
    }

    /**
     * 添加用户
     * @param user
     */

    public void addUser(User user){
        SqlSession sqlSession =  factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 修改用户
     * */
    public void update(int uno,String username,String sex,String password) {

    }





    public User login(String username,String password){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUser(username, password);
        sqlSession.close();
        return user;
    }
    public User selectEmail(String username,String email){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectEmail(username, email);
        sqlSession.close();
        return user;
    }
    public User add(String username,String password,String sex,String email){

        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.add(username,password,sex,email);
        User select = userMapper.select(username);
        sqlSession.commit();
        sqlSession.close();
        return select;
    }

    public void udatePsw( String username,String psw){
        SqlSession sqlSession=factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updatePsw(username,psw);

        sqlSession.commit();
        sqlSession.close();

    }
}
