package com.library.web;

import com.library.pojo.Librarian;
import com.library.pojo.User;
import com.library.service.librarianService;
import com.library.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//登录
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
    private userService service=new userService();
    private librarianService librarianService = new librarianService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取form表单，name中对应的值
        request.setCharacterEncoding("utf-8");//防乱码
        String username=request.getParameter("name");
        String password=request.getParameter("password");
        String select=request.getParameter("object");

        User user = service.login(username,password);


        if ("1".equals(select)&&user!=null){
            //把登录的用户存入session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if(!"冻结".equals(user.getState())){
                //重定向，跳转到新页面
                String contextPath = request.getContextPath();//获取/librarySystem/
                response.sendRedirect(contextPath+"/selectAllServlet");
            }
            else {
                request.setAttribute("login_msg","用户状态为冻结，请联系管理员");
               }
        }else if ("2".equals(select)){
            HttpSession session =  request.getSession();


        }else if ("3".equals(select)){

        }
        else{
            //跳转页面
            request.setAttribute("login_msg","用户名或密码错误");//传递警告信息到前端
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
