package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name="cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude  // Prevents infinite recursion
    private List<Cart_item> cartItems;

    @Column(nullable = false)
    private Double totalPrice;

    @Column(nullable = false)
    private int totalItems;
}
