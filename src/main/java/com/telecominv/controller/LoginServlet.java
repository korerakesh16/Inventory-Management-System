package com.telecominv.controller;

import com.telecominv.dao.UserDAO;
import com.telecominv.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDAO.validateUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect("views/add-equipment.jsp");
        } else {
            request.setAttribute("errorMsg", "Invalid username or password!");
            RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
            rd.forward(request, response);
        }
    }
}
