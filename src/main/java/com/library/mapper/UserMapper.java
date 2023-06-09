package com.library.mapper;

import com.library.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where uname = #{username} and upassword = #{password}")
    User selectUser(@Param("username")String username, @Param("password") String password);

    @Insert("INSERT INTO user(uname,usex,upassword,email)\n" +
            "VALUES(#{username},#{sex},#{password},#{email});\n")
    void add(@Param("username")String username,@Param("password") String password,@Param("sex") String sex,@Param("email") String email);

    @Select("select * from user where uname = #{username} ")
    User select(String username);

    @Select("SELECT *\n" +
            "FROM user\n" +
            "WHERE uname=#{username} AND email=#{email};\n")

    User selectEmail(@Param("username")String username, @Param("email") String email);

    @Select("UPDATE user\n" +
            "SET uname=#{username},upassword=#{password}\n" +
            "WHERE uname=#{username};\n")
    void updatePsw(@Param("username")String username, @Param("password") String password);



    /*用户管理*/

    /**
     * 查询所有用户*/
    @Select("select * from user")
    List<User> selectAllusers();
   /**
    *根据用户名查找用户
    * @param username
    * @return
    * */
    @Select("select * from user where uname=#{username} ")
    List<User> selectUserByUName(@Param("username") String username);
    /**
     * 根据用户编号查找用户
     * @param uno
     * @return
     * */
    @Select("select * from user where uno = # {uno} ")
    User selectUserByUno(@Param("uno") int uno);

    /**
     * 添加用户
     */
    @Insert("INSERT INTO user\n" +
            "VALUES(null,#{username},#{sex},#{password},NULL);\n")
    void addUser(User user);

    /**
     * 修改用户
     * @param uno
     * @param username
     * @param sex
     */
    @Update("UPDATE user\n" +
            "SET uname=#{username},usex=#{usex},password=#{upassword}\n" +
            "WHERE uno=#{uno};")
    void update(@Param("uno")int uno,@Param("username")String username,@Param("sex") String sex,@Param("upassword")String upassword);

    /**
     * 删除用户
     * @param uno
     */
    @Delete("DELETE FROM user \n" +
            "WHERE uno=#{uno};")
    Integer deleteUser(@Param("uno") int uno);
    /**
     * 冻结/解冻用户
     * @param uno
     * */
   /* @Select("select uname form user\n"+
            "where uno=#{uno};")
    void changeUserStatus(@Param("uno") int uno);*/

}
