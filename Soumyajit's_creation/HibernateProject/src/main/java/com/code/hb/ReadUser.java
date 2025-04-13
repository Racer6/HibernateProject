package com.code.hb;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Order;
import com.code.entity.OrderDetails;
import com.code.entity.Role;
import com.code.entity.User;

public class ReadUser {

    private SessionFactory sessionFactory;

    // Constructor with SessionFactory object
    public ReadUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // Create the session object
        Session session = sessionFactory.getCurrentSession();

        // Start the transaction
        session.beginTransaction();

        try {
            // Get all non-admin users (CUSTOMER only)
            List<User> users = session.createQuery("FROM User WHERE role = :role", User.class)
                    .setParameter("role", Role.CUSTOMER)
                    .getResultList();

            // Check if no users found
            if (users.isEmpty()) {
                System.out.println("No customers found.");
                session.getTransaction().commit();
                session.close();
                return;
            }

            // Display all non-admin users and their respective orders
            for (User user : users) {
                System.out.println("User: " + user.getUsername() +
                        ", Email: " + user.getEmail() +
                        ", Role: " + user.getRole());

                // Check if the user has any orders
                if (user.getOrders() != null && !user.getOrders().isEmpty()) {
                    for (Order order : user.getOrders()) {
                        System.out.println("Order ID: " + order.getId() +
                                ", Total Amount: " + order.getTotalAmount() +
                                ", Order Date: " + order.getOrderDate());

                        // Check if the order has order details
                        if (order.getOrderDetails() != null && !order.getOrderDetails().isEmpty()) {
                            for (OrderDetails orderDetails : order.getOrderDetails()) {
                                System.out.println(" Product: " + orderDetails.getProduct().getName() +
                                        ", Quantity: " + orderDetails.getQuantity() +
                                        ", Price: " + orderDetails.getUnitPrice());
                            }
                        } else {
                            System.out.println(" No order details found for this order.");
                        }
                    }
                } else {
                    System.out.println("No orders found for this user.");
                }
            }

            // Commit the transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback(); // Rollback in case of errors
        } finally {
            // Close the session
            session.close();
        }
    }
}
