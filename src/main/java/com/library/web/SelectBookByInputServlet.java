package com.library.web;

import com.library.pojo.Book;
import com.library.service.bookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectBookByInputServlet")
public class SelectBookByInputServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookService bookService = new bookService();
        String input = req.getParameter("input");

        List<Book> bookList = bookService.selectBookByInput(input);
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("librarian_booklist.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
