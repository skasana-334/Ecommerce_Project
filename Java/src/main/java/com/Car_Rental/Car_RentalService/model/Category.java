package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(){}
    public Category(String name) {
        this.name = name;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}