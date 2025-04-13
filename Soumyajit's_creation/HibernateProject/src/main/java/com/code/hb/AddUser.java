package com.code.hb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.code.entity.Order;
import com.code.entity.OrderDetails;
import com.code.entity.Product;
import com.code.entity.Role;
import com.code.entity.User;

public class AddUser {

    private SessionFactory sessionFactory;

    // Constructor with SessionFactory object
    public AddUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // Create the session object
        Session session = sessionFactory.getCurrentSession();

        // Start the transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Create Users with Orders
            User user1 = new User("Afzal", "password1", "afzal@example.com", Role.CUSTOMER);
            session.persist(user1);

            User user2 = new User("Avik", "password2", "avik@example.com", Role.CUSTOMER);
            session.persist(user2);

            // ✅ Add an Admin
            User admin1 = new User("Admin", "admin1", "admin@example.com", Role.ADMIN);
            session.persist(admin1);

            // Fetch products to associate with orders
            Product product1 = session.get(Product.class, 1L);
            Product product2 = session.get(Product.class, 2L);

            // Create Orders for user1
            Order order1 = new Order(new Timestamp(System.currentTimeMillis()), BigDecimal.valueOf(499.99), user1);
            session.persist(order1);

            Order order2 = new Order(new Timestamp(System.currentTimeMillis()), BigDecimal.valueOf(899.99), user1);
            session.persist(order2);

            // Add order details for user1 orders
            OrderDetails orderDetails1 = new OrderDetails(1, BigDecimal.valueOf(499.99), order1, product1);
            session.persist(orderDetails1);

            OrderDetails orderDetails2 = new OrderDetails(1, BigDecimal.valueOf(899.99), order2, product2);
            session.persist(orderDetails2);

            // Create Order for user2
            Order order3 = new Order(new Timestamp(System.currentTimeMillis()), BigDecimal.valueOf(19.99), user2);
            session.persist(order3);

            // Add order details for user2
            OrderDetails orderDetails3 = new OrderDetails(1, BigDecimal.valueOf(19.99), order3, product1);
            session.persist(orderDetails3);

            // Commit transaction
            transaction.commit();

            // Close the session
            session.close();
            System.out.println("Users with Orders and Admin added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of errors
            }
            session.close(); // Ensure session is closed
        }
    }
}
