package com.library.web;

import com.library.pojo.Book;
import com.library.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
//用户查看所有书籍
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private bookService service=new bookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用Service查询

       List<Book> books= service.selectAllBook();

        request.setAttribute("books",books);
//用户查看所有书籍
        request.getRequestDispatcher("/user_book.jsp").forward(request,response);
//管理员查看所有书籍
        request.getRequestDispatcher("/librarian_booklist.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
