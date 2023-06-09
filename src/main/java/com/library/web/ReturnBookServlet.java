package com.library.web;

import com.library.pojo.Book;
import com.library.pojo.User;
import com.library.pojo.returnRecord;
import com.library.service.bookService;
import com.library.service.returnRecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/returnBookServlet")
public class ReturnBookServlet extends HttpServlet {
    private returnRecordService service=new returnRecordService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bno=request.getParameter("bno");
        int n=Integer.parseInt(bno);
        service.returnBook(n);
        //从session中获取数据user
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        int uno=user.getUno();
        List<returnRecord> records= service.selectAllRecord(uno);
        //跳转页面，并存入信息
        request.setAttribute("records",records);
        request.getRequestDispatcher("/user_return.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
