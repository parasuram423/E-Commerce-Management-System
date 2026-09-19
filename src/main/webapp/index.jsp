 <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>E-Commerce Management System</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            color: #222;
        }

        header {
            background: #1f2937;
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
            max-width: 1100px;
            margin: 40px auto;
        }

        .section-title {
            text-align: center;
            margin-bottom: 25px;
        }

        .section-title h2 {
            margin-bottom: 8px;
        }

        .section-title p {
            color: #666;
        }

        .cards {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 20px;
        }

        .card {
            background: white;
            padding: 25px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
        }

        .icon {
            font-size: 40px;
            margin-bottom: 15px;
        }

        .card h3 {
            margin-bottom: 10px;
        }

        .card p {
            color: #666;
            font-size: 14px;
            margin-bottom: 20px;
            line-height: 1.5;
        }

        .btn {
            display: inline-block;
            padding: 10px 18px;
            background: #2563eb;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .btn:hover {
            opacity: 0.9;
        }

        .signup {
            background: #16a34a;
        }

        .signin {
            background: #7c3aed;
        }

        .address {
            background: #ea580c;
        }

        .update {
            background: #0891b2;
        }

        .delete {
            background: #dc2626;
        }

        footer {
            margin-top: 50px;
            background: #1f2937;
            color: #d1d5db;
            text-align: center;
            padding: 20px;
        }
    </style>
</head>

<body>

    <header>
        <h1>🛒 E-Commerce Management System</h1>
        <p>Product and User Management Application</p>
    </header>

    <div class="container">

        <!-- ACCOUNT MANAGEMENT -->

        <div class="section-title">
            <h2>Account Management</h2>
            <p>Create an account, login, or manage your address</p>
        </div>

        <div class="cards">

            <!-- SIGN UP -->

            <div class="card">
                <div class="icon">📝</div>

                <h3>Sign Up</h3>

                <p>Create a new user account.</p>

                <a href="signup" class="btn signup">
                    Sign Up
                </a>
            </div>

            <!-- SIGN IN -->

            <div class="card">
                <div class="icon">🔐</div>

                <h3>Sign In</h3>

                <p>Login to your existing account.</p>

                <a href="signin" class="btn signin">
                    Sign In
                </a>
            </div>

            <!-- ADDRESS -->

            <div class="card">
                <div class="icon">📍</div>

                <h3>Address</h3>

                <p>Add and view your addresses.</p>

                <a href="address" class="btn address">
                    Manage Address
                </a>
            </div>

        </div>


        <!-- PRODUCT MANAGEMENT -->

        <div class="section-title" style="margin-top: 50px;">

            <h2>Product Management</h2>

            <p>Manage products in the inventory</p>

        </div>

        <div class="cards">

            <!-- ADD PRODUCT -->

            <div class="card">

                <div class="icon">➕</div>

                <h3>Add Product</h3>

                <p>Add a new product to the inventory.</p>

                <a href="addproduct" class="btn">
                    Add Product
                </a>

            </div>


            <!-- SEARCH PRODUCT -->

            <div class="card">

                <div class="icon">🔍</div>

                <h3>Search Product</h3>

                <p>Search product by ID or name.</p>

                <a href="searchproduct" class="btn">
                    Search Product
                </a>

            </div>


            <!-- VIEW ALL PRODUCTS -->

            <div class="card">

                <div class="icon">📦</div>

                <h3>View All Products</h3>

                <p>View all products available in inventory.</p>

                <a href="viewallproducts" class="btn">
                    View Products
                </a>

            </div>


            <!-- UPDATE PRODUCT -->

            <div class="card">

                <div class="icon">✏️</div>

                <h3>Update Product</h3>

                <p>Update the name of an existing product.</p>

                <a href="updateproductname" class="btn update">
                    Update Product
                </a>

            </div>


            <!-- DELETE PRODUCT -->

            <div class="card">

                <div class="icon">🗑️</div>

                <h3>Remove Product</h3>

                <p>Remove a product from the inventory.</p>

                <a href="deleteproduct" class="btn delete">
                    Remove Product
                </a>

            </div>

        </div>

    </div>


    <footer>

        <p>© 2026 E-Commerce Management System</p>

    </footer>

</body>

</html>