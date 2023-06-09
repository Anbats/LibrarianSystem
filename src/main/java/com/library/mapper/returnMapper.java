package com.library.mapper;

import com.library.pojo.returnRecord;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface returnMapper {
    /**
     * 未还图书显示
     */
    @Select("SELECT book.bno 编号,bname 书名,bdate 借阅日期,\n" +
            "30-datediff(curdate(),bdate) 剩余天数\n" +
            "FROM book,borrow\n" +
            "WHERE book.bno=borrow.bno AND borrow.uno=#{uno} AND breturn=\"否\";\n")
   List<returnRecord>  selectReturnBook(int uno);

    /**
     * 还书
     */
    @Update("UPDATE book\n" +
            "SET inq=inq+1\n" +
            "WHERE bno=#{bno};\n")
    void returnBook(int bno);

}
