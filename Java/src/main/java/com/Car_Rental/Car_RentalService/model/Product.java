package com.Car_Rental.Car_RentalService.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
 private String stock;
    private double price;
private String color;
private int quantity;
    @ElementCollection
    @CollectionTable(name="sizes")
    private Set<Size> size=new HashSet<>();

    // One-to-Many relationship with Rating
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Size> getSize() {
        return size;
    }

    public void setSize(Set<Size> size) {
        this.size = size;
    }

    // One-to-Many relationship with Review
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
    // Constructors
    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;

    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    // No setter for id as it's auto-generated

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
// toString method


}
