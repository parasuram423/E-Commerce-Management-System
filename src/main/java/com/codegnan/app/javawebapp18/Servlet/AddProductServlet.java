 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import com.codegnan.app.javawebapp18.Service.ProductService;
import com.codegnan.app.javawebapp18.Service.ProductServiceImpl;
import com.codegnan.app.javawebapp18.dto.ProductDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var dispatcher =
                req.getRequestDispatcher("add-product-form.html");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        var productName = req.getParameter("pname");
        var brand = req.getParameter("pbrand");
        var description = req.getParameter("pdesc");
        var status = req.getParameter("pstatus");

        var currentDateTime = LocalDateTime.now();

        var productDto = new ProductDto(
                0,
                productName,
                brand,
                description,
                status,
                currentDateTime,
                currentDateTime
        );

        try {

            var isProductAdded =
                    productService.addProduct(productDto);

            if (isProductAdded) {

                resp.sendRedirect("add-product-success.html");

            } else {

                resp.setContentType("text/html");

                resp.getWriter().println(
                        "<h2>Error saving product to the inventory.</h2>"
                );

                resp.getWriter().println(
                        "<p>ProductDao returned false.</p>"
                );
            }

        } catch (Exception e) {

            resp.setContentType("text/html");

            resp.getWriter().println(
                    "<h2>Product Save Error</h2>"
            );

            resp.getWriter().println(
                    "<pre>"
                    + e.getMessage()
                    + "</pre>"
            );

            e.printStackTrace();
        }
    }
}