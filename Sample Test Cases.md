# Test Cases

This file contains sample test cases to verify the core functionalities of the ECommerce project


### Test Case 1: Create a New User

**Description**: Add a new user to the system

- **Input**:
  - `username`: testuser
  - `password`: sample123
  - `email`: test@example.com
  - `role`: CUSTOMER

- **Expected Output**:
  - User is successfully inserted into the database
  - The user has a unique ID generated automatically
  - Password is stored in hashed format using BCrypt

---

### Test Case 2: Insert a New Category

**Description**: Add a category to the stock

- **Input**:
  - `name`: Home Decor
  - `description`: contain various home decors like show pieces, statutes, and many more

- **Expected Output**:
  - Category is added with a unique ID
  - Category in available for storing Products in inventory
    
---

### Test Case 3: Insert a New Product

**Description**: Add a product to the inventory.

- **Input**:
  - `name`: Big Ben Statue 
  - `stockQuantity`: 50
  - `price`: 500.50

- **Expected Output**:
  - Product is added with a unique ID.
  - Available in stock for future orders.

---

### Test Case 4: Place an Order for an Existing User

**Description**: Confirm that an order for a product by an user is successfully placed and its associated order details are properly saved

- **Check for User with**:
  - `id`: 1 (must already exist)

- **Check for Product with**:  
  - `id`: 1 (must already exist)

- **Input for Order**:  
  - `orderDate`: 2
  - `totalAmount`: 1000.0

- **Input for OrderDetails**:
  - `quantity`: 2
  - `unitPrice`: 500.0

- **Expected Output**:
  - Checking if any `User` with `id` 1 and any `Product` with `id` 1 exist in the Database or not. If exist, then
  - A new entry in the `orders` table with a unique id
  - A new entry in the `OrderDetails` table with a unique id
    
