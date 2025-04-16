package com.Car_Rental.Car_RentalService.Request;

import com.Car_Rental.Car_RentalService.model.Category;
import com.Car_Rental.Car_RentalService.model.Size;

import java.util.HashSet;
import java.util.Set;

public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private Category cat;
    private String color;
    private int quantity;
    private Set<Size> size=new HashSet<>();

    public String getCat() {
        return cat.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

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

    public Set<Size> getSize() {
        return size;
    }

    public void setSize(Set<Size> size) {
        this.size = size;
    }
}
