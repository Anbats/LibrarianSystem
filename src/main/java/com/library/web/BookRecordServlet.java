package com.library.web;

import com.library.pojo.User;

import com.library.pojo.borrowRecord;
import com.library.service.borrowRecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookRecordServlet")
public class BookRecordServlet extends HttpServlet {
    private borrowRecordService service=new borrowRecordService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        int uno=user.getUno();
        List<borrowRecord> records = service.selectAllRecord(uno);
        request.setAttribute("records",records);
        request.getRequestDispatcher("/user_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
