 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;

import com.codegnan.app.javawebapp18.Service.UserService;
import com.codegnan.app.javawebapp18.Service.UserServiceImpl;
import com.codegnan.app.javawebapp18.dto.CredentialDto;
import com.codegnan.app.javawebapp18.dto.UserDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("user-registration-form.html");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var firstName = req.getParameter("fname");
        var lastName = req.getParameter("lname");
        var username = req.getParameter("uname");
        var loginPassword = req.getParameter("lpass");

        String hashedPassword =
                userService.hashPassword(loginPassword);

        UserDto userDto =
                new UserDto(0, firstName, lastName);

        CredentialDto credentialsDto =
                new CredentialDto(
                        0,
                        username,
                        hashedPassword,
                        null
                );

        boolean isUserSaved =
                userService.register(userDto, credentialsDto);

        if (isUserSaved) {

            resp.sendRedirect("user-registration-success.html");

        } else {

            resp.sendRedirect("user-registration-failure.html");
        }
    }
}