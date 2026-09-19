  package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;

import com.codegnan.app.javawebapp18.Service.ProductService;
import com.codegnan.app.javawebapp18.Service.ProductServiceImpl;
import com.codegnan.app.javawebapp18.dto.ProductDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchproduct")
public class SearchProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var dispatcher =
                req.getRequestDispatcher("search-product-form.html");

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductDto productDto = null;

        var productId = req.getParameter("pid");

        if (productId == null || productId.isBlank()) {

            var productName = req.getParameter("pname");

            productDto = productService.searchProduct(productName);

        } else {

            productDto =
                    productService.searchProduct(Integer.parseInt(productId));
        }

        req.setAttribute("PRODUCT", productDto);

        var dispatcher =
                req.getRequestDispatcher("product-info.jsp");

        dispatcher.forward(req, resp);
    }
}