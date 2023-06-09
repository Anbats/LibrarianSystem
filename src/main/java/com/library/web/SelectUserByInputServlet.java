package com.library.web;

import com.library.pojo.User;
import com.library.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//搜索查询用户

@WebServlet(name = "selectUserByInputServlet")
public class SelectUserByInputServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String input  = request.getParameter("input");
            //调用service方法
            List<User> userList = new userService().selectUserbyinput(input);
            //存入request域
            request.setAttribute("userList",userList);
            //转发到librarian_user.jsp
            request.getRequestDispatcher("/librarian_user.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
