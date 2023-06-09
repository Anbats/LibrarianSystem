package com.library.web;

import com.library.pojo.Book;
import com.library.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    private bookService service=new bookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("keyword");
        List<Book> res = null;
        try {
            if ("".equals(param) && param.length() == 0) {
                res = service.selectAllBook();
            } else {
                res = service.query(param);
            }
        } catch (Exception e) {
            e.printStackTrace();}

        request.setAttribute("books", res);
        request.getRequestDispatcher("/user_book.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
