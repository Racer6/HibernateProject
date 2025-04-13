package com.code.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    // Member variables
    // Mapped each member variable to column
    // Declared one variable as PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Create a default constructor
    public OrderDetails() {
        // Set the default value
        this.id = 0L;
        this.quantity = 0;
        this.unitPrice = BigDecimal.ZERO;
        this.order = null;
        this.product = null;
    }

    // Create a constructor with parameters
    public OrderDetails(Integer quantity, BigDecimal unitPrice, Order order, Product product) {
        super();
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
        this.product = product;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // toString()
    @Override
    public String toString() {
        return "OrderDetails [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
    }
}
