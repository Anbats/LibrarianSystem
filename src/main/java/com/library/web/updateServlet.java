package com.library.web;

import com.library.pojo.Book;
import com.library.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( "/updateServlet")
public class updateServlet extends HttpServlet {
    private bookService service=new bookService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String bno=request.getParameter("bno");
        int n=Integer.parseInt(bno);
        service.lend(n);
        List<Book> books= service.selectAllBook();
        request.setAttribute("books",books);
        request.getRequestDispatcher("/user_book.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
