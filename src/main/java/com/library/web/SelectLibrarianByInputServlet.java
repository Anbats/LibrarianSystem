package com.library.web;

import com.library.pojo.Librarian;
import com.library.service.librarianService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectLibrarianByInputServlet")
public class SelectLibrarianByInputServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String input  = request.getParameter("input");
        //调用service方法
        List<Librarian> librarianList = new librarianService().selectLibrarianByInput(input);
        //存入request域
        request.setAttribute("librarianList" ,librarianList);
        //转发到librarian_user.jsp
        request.getRequestDispatcher("/librarian_user.jsp").forward(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
