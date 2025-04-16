package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship with User
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many-to-One relationship with Product
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Rating value (e.g., from 1 to 5)
    @Column(nullable = false)
    private double rating;

    // Timestamp of when the rating was made
    @Column(name = "rated_at", nullable = false)
    private LocalDateTime ratedAt;

    // Constructors
    public Rating() {
        // Default constructor required by JPA
    }

    public Rating(User user, Product product, double rating, LocalDateTime ratedAt) {
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.ratedAt = ratedAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    // No setter for id as it's auto-generated

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(LocalDateTime ratedAt) {
        this.ratedAt = ratedAt;
    }
}
