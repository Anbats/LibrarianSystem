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
/**
 *用户
 * */
@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
   userService userService = new userService();
//查询全部
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //调用service方法
       List<User> users = userService.selectAllusers();
     //存入request域
      req.setAttribute("users",users);
     //转发到librarian_user.jsp
     req.getRequestDispatcher("/librarian_user.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //添加用户


    //修改用户


    //删除用户


    //冻结、解冻用户
}
