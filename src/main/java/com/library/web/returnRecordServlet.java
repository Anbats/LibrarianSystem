package com.library.web;

import com.library.pojo.User;
import com.library.pojo.borrowRecord;
import com.library.pojo.returnRecord;
import com.library.service.returnRecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/returnRecordServlet")
public class returnRecordServlet extends HttpServlet {
    private returnRecordService service=new returnRecordService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        int uno=user.getUno();
        List<returnRecord> records = service.selectAllRecord(uno);
        request.setAttribute("records",records);
        request.getRequestDispatcher("/user_return.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
