 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;

import com.codegnan.app.javawebapp18.Service.ProductService;
import com.codegnan.app.javawebapp18.Service.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateproductname")
public class UpdateProductNameServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("update-product-name-form.html")
           .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            int productId = Integer.parseInt(req.getParameter("pid"));

            String updatedName = req.getParameter("pname");

            boolean isUpdated =
                    productService.renameProduct(productId, updatedName);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            if (isUpdated) {

                resp.getWriter().println("""
                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <title>Update Successful</title>

                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f4f6f8;
                                margin: 0;
                                padding: 0;
                            }

                            .container {
                                width: 450px;
                                margin: 120px auto;
                                background-color: white;
                                padding: 40px;
                                border-radius: 12px;
                                text-align: center;
                                box-shadow: 0 4px 15px rgba(0,0,0,0.12);
                            }

                            .icon {
                                font-size: 55px;
                                margin-bottom: 15px;
                            }

                            h2 {
                                color: #16a34a;
                                margin-bottom: 20px;
                            }

                            p {
                                color: #555;
                                margin: 10px 0;
                            }

                            .button {
                                display: inline-block;
                                margin-top: 25px;
                                padding: 12px 25px;
                                background-color: #2563eb;
                                color: white;
                                text-decoration: none;
                                border-radius: 6px;
                            }

                            .button:hover {
                                background-color: #1d4ed8;
                            }
                        </style>
                    </head>

                    <body>

                        <div class="container">

                            <div class="icon">✅</div>

                            <h2>Product Updated Successfully!</h2>

                            <p>
                                Product ID: <strong>"""
                    + productId +
                    """
                                </strong>
                            </p>

                            <p>
                                New Product Name: <strong>"""
                    + updatedName +
                    """
                                </strong>
                            </p>

                            <a class="button" href="updateproductname">
                                Update Another Product
                            </a>

                            <br><br>

                            <a class="button" href="index.jsp">
                                Back to Home
                            </a>

                        </div>

                    </body>
                    </html>
                    """);

            } else {

                resp.getWriter().println("""
                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <title>Product Not Found</title>

                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f4f6f8;
                                margin: 0;
                                padding: 0;
                            }

                            .container {
                                width: 450px;
                                margin: 120px auto;
                                background-color: white;
                                padding: 40px;
                                border-radius: 12px;
                                text-align: center;
                                box-shadow: 0 4px 15px rgba(0,0,0,0.12);
                            }

                            .icon {
                                font-size: 55px;
                                margin-bottom: 15px;
                            }

                            h2 {
                                color: #dc2626;
                                margin-bottom: 15px;
                            }

                            p {
                                color: #666;
                                margin-bottom: 25px;
                            }

                            .button {
                                display: inline-block;
                                padding: 12px 25px;
                                background-color: #2563eb;
                                color: white;
                                text-decoration: none;
                                border-radius: 6px;
                            }

                            .button:hover {
                                background-color: #1d4ed8;
                            }
                        </style>
                    </head>

                    <body>

                        <div class="container">

                            <div class="icon">❌</div>

                            <h2>Product Not Found</h2>

                            <p>
                                No product found with Product ID:
                                <strong>"""
                    + productId +
                    """
                                </strong>
                            </p>

                            <a class="button" href="updateproductname">
                                Try Again
                            </a>

                            <br><br>

                            <a class="button" href="index.jsp">
                                Back to Home
                            </a>

                        </div>

                    </body>
                    </html>
                    """);
            }

        } catch (Exception e) {

            e.printStackTrace();

            resp.setContentType("text/html");

            resp.getWriter().println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Server Error</title>
                </head>

                <body>

                    <h2>Server Issue</h2>

                    <p>Please check the Product ID and try again.</p>

                    <a href="updateproductname">Try Again</a>
                    <br><br>
                    <a href="index.jsp">Back to Home</a>

                </body>
                </html>
                """);
        }
    }
}