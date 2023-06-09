package com.library.mapper;


import com.library.pojo.borrowRecord;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface borrowRecordMapper {
    /**
     * 查询所有借书记录
     * @return
     */
    @Select("SELECT book.bno 编号,bname 书名,bdate 借阅日期,ldate 归还日期,breturn 是否归还\n" +
            "FROM book,borrow\n" +
            "WHERE book.bno=borrow.bno AND borrow.uno=#{uno};\n")
    List<borrowRecord> selectAllRecord(int uno);


}
