 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;

import com.codegnan.app.javawebapp18.Service.UserService;
import com.codegnan.app.javawebapp18.Service.UserServiceImpl;
import com.codegnan.app.javawebapp18.dto.CredentialDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("user-login-form.html");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var username = req.getParameter("uname");
        var loginPassword = req.getParameter("lpass");

        CredentialDto credentialDto =
                userService.login(username, loginPassword);

        if (credentialDto != null) {

            HttpSession session = req.getSession();

            session.setAttribute(
                    "USERDTO",
                    credentialDto.userDto()
            );

            resp.sendRedirect("user-login-success.jsp");

        } else {

            resp.sendRedirect("user-login-failure.html");
        }
    }
}