package com.library.mapper;

import com.library.pojo.Librarian;
import com.library.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LibrarianMapper {
    /**
     * 图书管理员登录
     * @param mname
     * @param mpassword
     * @return
     */
    @Select("select * from librarian where mname = #{mname} and mpassword = #{mpassword}")
    Librarian selectLibrarian(@Param("mname")String mname, @Param("mpassword") String mpassword);

    /**
     *查询所有图书管理员
     * @return
     * */
    @Select("select * from librarian")
    List<Librarian> selectAllLibrarian();

    /**
     * 根据名字查找
     * @return
     * @param mname
     * */
      @Select("select * from librarian where mname = #{mname} ")
      List<Librarian> selectLibrarianByMName(@Param("mname") String mname);
    /**
     * 根据编号查找
     * @return
     * @param mno
     * */
    @Select("select * from librarian where bmno = #{mno} ")
    List<Librarian> selectLibrarianByMno(@Param("mno") int mno);

    /**
     * 添加图书管理员
     * */
    @Insert("insert into librarian(mname,msex,mpassword)\n" +
            "values(#{mname},#{msex},#{mpassword})")
    void addLibrarian(Librarian librarian);

    /**
     * 删除图书管理员
     * @param mno
     * */
    @Delete("DELETE FROM librarian\n" +
            "WHERE bmno=#{mno};")
    Integer deleteLibrarian(@Param("mno") int mno);


}
