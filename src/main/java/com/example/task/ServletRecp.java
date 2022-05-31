package com.example.task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRecp", value = "/ServletRecp")
public class ServletRecp extends HttpServlet {
    int status = 0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("userpass");
        status = sqlFunction.loginRecep("hotel",name,password);
        if(status!=0 ){
            HttpSession session= request.getSession();
            session.setAttribute("recpLogin",name);
            String currentPage = (String) session.getAttribute("currentPage");
            if(currentPage==null) {
                response.sendRedirect("receptionist/Home.jsp");
            }
            else{
                response.sendRedirect(currentPage);
            }
        }
        else{
            response.sendRedirect("receptionist/receptionistLogin.jsp");
        }
    }
}
