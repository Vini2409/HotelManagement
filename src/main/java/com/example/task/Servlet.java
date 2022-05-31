package com.example.task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    int status = 0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("guestid");
        String password = request.getParameter("guestpass");
        status = sqlFunction.guestLogin(name,password);
        if(status > 0 ){
            System.out.println("+");
            HttpSession session= request.getSession();
            session.setAttribute("validid",name);
            String currentPage = (String) session.getAttribute("currentPage");
            if(currentPage==null) {
                response.sendRedirect("user/HomePage.jsp");
            }
            else{
                response.sendRedirect(currentPage);
            }
        }
        else{
            response.sendRedirect("user/guestLogin.jsp");
        }
    }
}
