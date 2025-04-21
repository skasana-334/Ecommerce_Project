package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
@OneToOne
@JoinColumn(name="user_id",nullable=false)
    private User user;

@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    @Column(name="cart_items")
    private Set<cartItem> cartItems=new HashSet<>();

private double total_price;
private int totalItem;

    public Cart() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<cartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<cartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }
}