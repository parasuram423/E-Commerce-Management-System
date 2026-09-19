 <%@ page import="com.codegnan.app.javawebapp18.dto.ProductDto" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Product Information</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            color: #222;
        }

        header {
            background-color: #1f2937;
            color: white;
            text-align: center;
            padding: 30px 20px;
        }

        header h1 {
            margin-bottom: 8px;
        }

        header p {
            color: #d1d5db;
        }

        .container {
            width: 90%;
            max-width: 600px;
            margin: 50px auto;
        }

        .product-card {
            background-color: white;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.10);
        }

        .product-icon {
            text-align: center;
            font-size: 55px;
            margin-bottom: 15px;
        }

        .product-name {
            text-align: center;
            font-size: 28px;
            font-weight: bold;
            color: #1f2937;
            margin-bottom: 25px;
        }

        .detail {
            padding: 14px 0;
            border-bottom: 1px solid #e5e7eb;
        }

        .detail:last-child {
            border-bottom: none;
        }

        .label {
            display: inline-block;
            width: 130px;
            font-weight: bold;
            color: #374151;
            vertical-align: top;
        }

        .value {
            color: #555;
        }

        .status {
            display: inline-block;
            padding: 6px 14px;
            border-radius: 20px;
            font-size: 13px;
            font-weight: bold;
        }

        .active {
            background-color: #dcfce7;
            color: #15803d;
        }

        .inactive {
            background-color: #fee2e2;
            color: #b91c1c;
        }

        .draft {
            background-color: #fef3c7;
            color: #b45309;
        }

        .not-found {
            background-color: white;
            text-align: center;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.10);
        }

        .not-found h2 {
            color: #dc2626;
            margin-bottom: 12px;
        }

        .not-found p {
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

        .back {
            display: block;
            width: fit-content;
            margin: 30px auto 0;
            padding: 12px 25px;
            background-color: #2563eb;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .back:hover {
            background-color: #1d4ed8;
        }

        footer {
            margin-top: 50px;
            background-color: #1f2937;
            color: #d1d5db;
            text-align: center;
            padding: 20px;
        }
    </style>
</head>

<body>

    <header>
        <h1>🛍️ Product Information</h1>
        <p>Detailed Product Information</p>
    </header>

    <div class="container">

        <%
            ProductDto productDto =
                    (ProductDto) request.getAttribute("PRODUCT");

            if (productDto != null) {

                String statusClass = "";

                if ("Active".equalsIgnoreCase(productDto.status())) {
                    statusClass = "active";
                } else if ("Inactive".equalsIgnoreCase(productDto.status())) {
                    statusClass = "inactive";
                } else if ("Draft".equalsIgnoreCase(productDto.status())) {
                    statusClass = "draft";
                }
        %>

        <div class="product-card">

            <div class="product-icon">📦</div>

            <div class="product-name">
                <%= productDto.name() %>
            </div>

            <div class="detail">
                <span class="label">Product ID:</span>
                <span class="value">
                    <%= productDto.id() %>
                </span>
            </div>

            <div class="detail">
                <span class="label">Brand:</span>
                <span class="value">
                    <%= productDto.brand() %>
                </span>
            </div>

            <div class="detail">
                <span class="label">Description:</span>
                <span class="value">
                    <%= productDto.description() %>
                </span>
            </div>

            <div class="detail">
                <span class="label">Status:</span>
                <span class="status <%= statusClass %>">
                    <%= productDto.status() %>
                </span>
            </div>

            <div class="detail">
                <span class="label">Created At:</span>
                <span class="value">
                    <%= productDto.createdAt() %>
                </span>
            </div>

            <div class="detail">
                <span class="label">Updated At:</span>
                <span class="value">
                    <%= productDto.updatedAt() %>
                </span>
            </div>

        </div>

        <a class="back" href="index.jsp">
            ← Back to Home
        </a>

        <%
            } else {
        %>

        <div class="not-found">

            <div class="product-icon">❌</div>

            <h2>Product Not Found</h2>

            <p>
                Product not found by the given ID.
            </p>

            <a class="button" href="searchproduct">
                Search Again
            </a>

        </div>

        <%
            }
        %>

    </div>

    <footer>
        <p>© 2026 E-Commerce Management System</p>
    </footer>

</body>

</html>