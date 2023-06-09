package com.library.web;

import com.library.pojo.Book;
import com.library.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/updatePswServlet")
public class UpdatePswServlet extends HttpServlet {
    private userService service=new userService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String psw=request.getParameter("psw");
        String email=request.getParameter("email");

        String str=email.replaceAll("%40","@");
if(service.selectEmail(name,str)!=null){
    service.udatePsw(name,psw);
    request.getRequestDispatcher("/login.jsp").forward(request,response);

}else {
    request.setAttribute("login_msg","用户名与邮箱不匹配");
    request.getRequestDispatcher("/login.jsp").forward(request,response);
}





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
