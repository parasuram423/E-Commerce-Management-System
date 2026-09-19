 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;
import java.util.List;

import com.codegnan.app.javawebapp18.Service.ProductService;
import com.codegnan.app.javawebapp18.Service.ProductServiceImpl;
import com.codegnan.app.javawebapp18.dto.ProductDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewallproducts")
public class ViewAllProductsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<ProductDto> productDtosList =
                productService.getAllProducts();

        req.setAttribute("PRODUCTSLIST", productDtosList);

        var dispatcher =
                req.getRequestDispatcher("products-list.jsp");

        dispatcher.forward(req, resp);
    }
}