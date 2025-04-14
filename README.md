# E-Commerce Management System using Hibernate ORM

## Overview

This project showcases a basic implementation of Object-Relational Mapping (ORM) using the **Hibernate Framework**. It is designed to build an **E-Commerce Management System** that allows seamless management of **Categories, Products, Users**, and **Orders**, with each order containing multiple **Order Details**.

### Technologies Used
- Hibernate Framework
- JDBC
- MySQL (as the Database)
- Eclipse IDE (or any preferred Java IDE)

> **Note:** [Click here to view the Database Schema] *(Insert hyperlink if available)*

## Project Features
- Add and manage **Categories**, **Products**, and **Users**
- Place **Orders** with multiple associated **Order Details**
- Retrieve **Orders** along with related **Users** and **Products**

## Setup Instructions

### 1. Open the Project in Your IDE
- Launch the project in **Eclipse**, **IntelliJ IDEA**, or any Java IDE of your choice.

### 2. Configure Project Dependencies
- Ensure that all necessary dependencies are defined correctly in the `pom.xml` file.
- Refer to the `pom.xml` for verification and dependency management.

### 3. Configure the Database
- Set up a local **MySQL** database instance.
- Update the `hibernate.cfg.xml` file with your specific configuration:
  - Database URL (with the correct port and database name)
  - Username
  - Password
- Refer to the sample `hibernate.cfg.xml` for a clear example.

### 4. Customize Entity Definitions (Optional)
- You may modify the entity classes as per your requirements or retain the default structure.
- [View Entity Definitions Here] *(Insert hyperlink if available)*

### 5. Run the Application
- Ensure the MySQL server is running and the database specified in `hibernate.cfg.xml` is already created.
- Run `App.java` to initiate the `SessionFactory` and auto-generate the required database tables.
- The `SessionFactory` lifecycle is managed via `HibernateUtil.java`.

### 6. Verify Database and Output
- Use **MySQL Workbench** or the **Command Line Client** to confirm that data has been created and stored as expected.

## Development Highlights
- Java classes are annotated with JPA annotations such as `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@OneToMany`, and `@ManyToOne` for effective ORM implementation.
- Entity relationships are mapped using accurate cardinality annotations as supported by the Hibernate framework.
- Passwords are securely hashed using **BCrypt** before being stored in the database.
- [View Test Cases Here] *(Insert hyperlink if available)*

## Author

**Soumyajit Sarkar**  
*Developer and Creator of the E-Commerce Management System using Hibernate ORM.*
