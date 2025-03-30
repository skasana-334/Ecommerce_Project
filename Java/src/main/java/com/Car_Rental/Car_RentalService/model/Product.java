package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID

    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
