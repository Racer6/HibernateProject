----->>> Test Cases for E-Commerce Project---->>>
This file contains sample test cases to verify the core functionalities of the E-Commerce system.

🧪 Test Case 1: Register a New User
Description: Add a new user to the system and validate user creation.

Input:

{
  "username": "testuser",
  "password": "sample123",
  "email": "test@example.com",
  "role": "CUSTOMER"
}
Expected Output:

User is successfully inserted into the database.

A unique user ID is generated automatically.

Password is stored securely using BCrypt hashing.

🧪 Test Case 2: Add New Category
Description: Add a new product category to the inventory system.

Input:

{
  "name": "Home Decor",
  "description": "Contains various home decors like show pieces, statues, and more."
}
Expected Output:

Category is created with a unique ID.

Category becomes available for product assignment in inventory.

🧪 Test Case 3: Add New Product
Description: Add a product to the stock inventory.

Input:

{
  "name": "Big Ben Statue",
  "stockQuantity": 50,
  "price": 500.50
}
Expected Output:

Product is successfully added with a unique product ID.

Product is available in stock for future orders.

🧪 Test Case 4: Place an Order
Description: Place an order by an existing user and validate if order and order details are saved correctly.

Preconditions:

User with id: 1 must exist.

Product with id: 1 must exist.

Order Input:

{
  "orderDate": "2025-04-14",
  "totalAmount": 1000.0
}
OrderDetails Input:

{
  "productId": 1,
  "quantity": 2,
  "unitPrice": 500.0
}
Expected Output:

Validation that user with id: 1 and product with id: 1 exists.

New entry is created in the orders table with a unique order ID.

Corresponding entry in the order_details table is added with reference to the order.
