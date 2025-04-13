package com.code.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    // Member variables
    // Mapped each member variable to column
    // Declared one variable as PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    // Create a relationship
    // ManyToOne with Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Create a default constructor
    public Product() {
        // Set the default value
        this.id = 0L;
        this.name = null;
        this.price = BigDecimal.ZERO;
        this.stockQuantity = 0;
        this.category = null;
    }

    // Create a constructor with parameters
    public Product(String name, BigDecimal price, Integer stockQuantity, Category category) {
        super();
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // toString()
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity
                + ", category=" + category + "]";
    }
}
