 <%@ page import="com.codegnan.app.javawebapp18.dto.ProductDto" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>All Products</title>

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
            width: 95%;
            max-width: 1200px;
            margin: 40px auto;
        }

        .products-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
            gap: 25px;
        }

        .product-card {
            background-color: white;
            border-radius: 12px;
            padding: 25px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.10);
            transition: transform 0.2s ease;
        }

        .product-card:hover {
            transform: translateY(-4px);
        }

        .product-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .product-id {
            font-size: 14px;
            color: #666;
            font-weight: bold;
        }

        .product-name {
            font-size: 22px;
            font-weight: bold;
            margin-bottom: 15px;
            color: #1f2937;
        }

        .product-details {
            margin-top: 10px;
        }

        .detail {
            margin-bottom: 12px;
            line-height: 1.5;
        }

        .label {
            font-weight: bold;
            color: #374151;
        }

        .value {
            color: #555;
        }

        .description {
            min-height: 48px;
        }

        .status {
            display: inline-block;
            padding: 6px 12px;
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

        .date {
            font-size: 13px;
            color: #666;
            word-break: break-word;
        }

        .no-products {
            text-align: center;
            background-color: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
        }

        .back {
            display: block;
            width: fit-content;
            margin: 35px auto 0;
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
        <h1>📦 Product Inventory</h1>
        <p>All Products Available in the System</p>
    </header>

    <div class="container">

        <%
            List<ProductDto> productDtoList =
                    (List<ProductDto>) request.getAttribute("PRODUCTSLIST");

            if (productDtoList != null && !productDtoList.isEmpty()) {
        %>

        <div class="products-grid">

            <%
                for (ProductDto productDto : productDtoList) {

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

                <div class="product-header">

                    <div class="product-id">
                        Product ID: <%= productDto.id() %>
                    </div>

                    <span class="status <%= statusClass %>">
                        <%= productDto.status() %>
                    </span>

                </div>

                <div class="product-name">
                    <%= productDto.name() %>
                </div>

                <div class="product-details">

                    <div class="detail">
                        <span class="label">Brand:</span>
                        <span class="value">
                            <%= productDto.brand() %>
                        </span>
                    </div>

                    <div class="detail description">
                        <span class="label">Description:</span>
                        <span class="value">
                            <%= productDto.description() %>
                        </span>
                    </div>

                    <div class="detail">
                        <span class="label">Created At:</span><br>
                        <span class="date">
                            <%= productDto.createdAt() %>
                        </span>
                    </div>

                    <div class="detail">
                        <span class="label">Updated At:</span><br>
                        <span class="date">
                            <%= productDto.updatedAt() %>
                        </span>
                    </div>

                </div>

            </div>

            <%
                }
            %>

        </div>

        <%
            } else {
        %>

        <div class="no-products">
            <h2>📭 No Products Found</h2>
            <p style="margin-top: 10px; color: #666;">
                There are currently no products available in the inventory.
            </p>
        </div>

        <%
            }
        %>

        <a class="back" href="index.jsp">
            ← Back to Home
        </a>

    </div>

    <footer>
        <p>© 2026 E-Commerce Management System</p>
    </footer>

</body>

</html>