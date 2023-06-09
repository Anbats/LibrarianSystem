package com.library.web;

import com.library.pojo.User;
import com.library.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//添加用户
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    private userService service = new userService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理post请求乱码问题
        req.setCharacterEncoding("utf-8");
        //加收表单数据封装为对象
        String username  = req.getParameter("uname");
        String usersex  = req.getParameter("sex1");
        String userp  = req.getParameter("upassword");
        String email  = req.getParameter("email");



        User user = new User();
        user.setUsername(username);
        user.setSex(usersex);
        user.setPassword(userp);

        service.add(username, userp, usersex, email);
        req.getRequestDispatcher("/SelectUserServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

