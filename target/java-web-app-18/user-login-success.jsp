 <%@ page import="com.codegnan.app.javawebapp18.dto.UserDto" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login Success</title>

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
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
        }

        .icon {
            font-size: 55px;
            margin-bottom: 15px;
        }

        h2 {
            color: #16a34a;
            margin-bottom: 15px;
        }

        .welcome {
            font-size: 20px;
            color: #333;
            margin-bottom: 25px;
        }

        .button {
            display: inline-block;
            padding: 12px 25px;
            background-color: #2563eb;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 16px;
        }

        .button:hover {
            background-color: #1d4ed8;
        }
    </style>
</head>

<body>

<%
    UserDto userDto = (UserDto) session.getAttribute("USERDTO");
%>

<div class="container">

    <div class="icon">✅</div>

    <h2>Login Successful!</h2>

    <div class="welcome">
        Welcome, <strong>
            <%= userDto.firstName() %>
            <%= userDto.lastName() %>
        </strong>
    </div>

    <a class="button" href="index.jsp">Go to Home</a>

</div>

</body>

</html>