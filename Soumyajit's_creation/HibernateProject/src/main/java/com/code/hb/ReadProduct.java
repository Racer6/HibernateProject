package com.code.hb;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Product;

public class ReadProduct {

    private SessionFactory sessionFactory;

    // Constructor with SessionFactory object
    public ReadProduct(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // Create the session object
        Session session = sessionFactory.getCurrentSession();

        // Start the transaction
        session.beginTransaction();

        try {
            // Create the query to get all Product objects
            List<Product> products = session.createQuery("from Product", Product.class).getResultList();

            // Check if there are no products
            if (products.isEmpty()) {
                System.out.println("No products found.");
                session.getTransaction().commit();
                session.close();
                return;
            }

            // Read and display each product
            for (Product product : products) {
                System.out.println("Product: " + product.getName() +
                        ", Price: " + product.getPrice() +
                        ", Stock: " + product.getStockQuantity() +
                        ", Category: " + product.getCategory().getName());
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
