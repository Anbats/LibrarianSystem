package com.library.web;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Book;
import com.library.service.bookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showDetailServlet")
public class ShowDetailServlet extends HttpServlet {
    private bookService service=new bookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用Service查询


       String id=request.getParameter("bno");
       int n=Integer.parseInt(id);
        String record= service.detail(n);
        request.setAttribute("book",record);
        request.getRequestDispatcher("/detail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
