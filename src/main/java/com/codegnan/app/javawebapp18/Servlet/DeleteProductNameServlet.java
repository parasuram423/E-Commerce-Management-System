 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;

import com.codegnan.app.javawebapp18.Service.ProductService;
import com.codegnan.app.javawebapp18.Service.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteproduct")
public class DeleteProductNameServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var dispatcher =
                req.getRequestDispatcher("delete-product-form.html");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var productId = Integer.parseInt(req.getParameter("pid"));

        var isProductRemoved =
                productService.removeProduct(productId);

        if (isProductRemoved) {
            resp.sendRedirect("add-product-success.html");
        } else {
            resp.sendRedirect("add-product-failure.html");
        }
    }
}