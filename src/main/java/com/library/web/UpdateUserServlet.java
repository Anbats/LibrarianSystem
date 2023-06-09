package com.library.web;

import com.library.pojo.User;
import com.library.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    private userService service= new userService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        User user = service.selectUserByuno(Integer.parseInt(id));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/librarian_user.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
