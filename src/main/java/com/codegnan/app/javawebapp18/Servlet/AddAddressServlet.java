 package com.codegnan.app.javawebapp18.Servlet;

import java.io.IOException;

import com.codegnan.app.javawebapp18.dao.AddressDao;
import com.codegnan.app.javawebapp18.dao.AddressDaoImpl;
import com.codegnan.app.javawebapp18.dto.AddressDto;
import com.codegnan.app.javawebapp18.dto.UserDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/address")
public class AddAddressServlet extends HttpServlet {

    private AddressDao addressDao;

    @Override
    public void init() throws ServletException {
        addressDao = new AddressDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        resp.getWriter().println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Address Management</title>

                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f4f6f8;
                            margin: 0;
                            padding: 0;
                        }

                        .container {
                            width: 450px;
                            margin: 40px auto;
                            background: white;
                            padding: 30px;
                            border-radius: 10px;
                            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
                        }

                        h2 {
                            text-align: center;
                            margin-bottom: 25px;
                        }

                        label {
                            display: block;
                            margin-top: 12px;
                            margin-bottom: 5px;
                            font-weight: bold;
                        }

                        input {
                            width: 100%;
                            padding: 10px;
                            border: 1px solid #ccc;
                            border-radius: 5px;
                            box-sizing: border-box;
                        }

                        input[type="submit"] {
                            margin-top: 20px;
                            background-color: #2563eb;
                            color: white;
                            border: none;
                            cursor: pointer;
                            font-size: 16px;
                        }

                        input[type="submit"]:hover {
                            background-color: #1d4ed8;
                        }

                        .back {
                            display: block;
                            text-align: center;
                            margin-top: 20px;
                            text-decoration: none;
                            color: #2563eb;
                        }
                    </style>
                </head>

                <body>

                    <div class="container">

                        <h2>📍 Add Address</h2>

                        <form action="address" method="post">

                            <label>User ID</label>
                            <input type="number"
                                   name="userId"
                                   required>

                            <label>Label</label>
                            <input type="text"
                                   name="label"
                                   placeholder="Home / Office"
                                   required>

                            <label>Line 1</label>
                            <input type="text"
                                   name="line1"
                                   required>

                            <label>Line 2</label>
                            <input type="text"
                                   name="line2">

                            <label>Line 3</label>
                            <input type="text"
                                   name="line3">

                            <label>City</label>
                            <input type="text"
                                   name="city"
                                   required>

                            <label>State</label>
                            <input type="text"
                                   name="state"
                                   required>

                            <label>Pincode</label>
                            <input type="text"
                                   name="pincode"
                                   required>

                            <input type="submit"
                                   value="Save Address">

                        </form>

                        <a class="back" href="index.jsp">
                            ← Back to Home
                        </a>

                    </div>

                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            int userId = Integer.parseInt(
                    req.getParameter("userId")
            );

            String label = req.getParameter("label");
            String line1 = req.getParameter("line1");
            String line2 = req.getParameter("line2");
            String line3 = req.getParameter("line3");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String pincode = req.getParameter("pincode");

            UserDto userDto = new UserDto(
                    userId,
                    "",
                    ""
            );

            AddressDto addressDto = new AddressDto(
                    0,
                    label,
                    line1,
                    line2,
                    line3,
                    city,
                    state,
                    pincode,
                    userDto
            );

            boolean isSaved = addressDao.save(addressDto);

            resp.setContentType("text/html");

            if (isSaved) {

                resp.getWriter().println("""
                        <html>
                        <head>
                            <title>Address Saved</title>
                        </head>

                        <body>

                            <h2>Congratulations!!!</h2>

                            <h3>Address Saved Successfully.</h3>

                            <p>Address has been added to the user account.</p>

                            <br>

                            <a href="address">
                                Add Another Address
                            </a>

                            <br><br>

                            <a href="index.jsp">
                                Back to Home
                            </a>

                        </body>
                        </html>
                        """);

            } else {

                resp.getWriter().println("""
                        <html>
                        <body>

                            <h2>Failed to Save Address</h2>

                            <p>Please check the User ID and try again.</p>

                            <br>

                            <a href="address">
                                Try Again
                            </a>

                        </body>
                        </html>
                        """);
            }

        } catch (Exception e) {

            resp.setContentType("text/html");

            resp.getWriter().println("<html>");
            resp.getWriter().println("<body>");

            resp.getWriter().println(
                    "<h2>Address Save Error</h2>"
            );

            resp.getWriter().println(
                    "<pre>" + e.getMessage() + "</pre>"
            );

            resp.getWriter().println(
                    "<br><a href='address'>Go Back</a>"
            );

            resp.getWriter().println("</body>");
            resp.getWriter().println("</html>");

            e.printStackTrace();
        }
    }
}