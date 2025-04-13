package com.code.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    // Member variables
    // Mapped each member variable to column
    // Declared one variable as PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Updated to FetchType.EAGER
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetails;

    // Create a default constructor
    public Order() {
        // Set the default value
        this.id = 0L;
        this.orderDate = new Timestamp(System.currentTimeMillis());
        this.totalAmount = BigDecimal.ZERO;
        this.user = null;
        this.orderDetails = new ArrayList<>();
    }

    // Create a constructor with parameters
    public Order(Timestamp orderDate, BigDecimal totalAmount, User user) {
        super();
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
        this.orderDetails = new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    // toString()
    @Override
    public String toString() {
        return "Order [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", orderDetails="
                + orderDetails + "]";
    }
}
