package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;
@Embeddable
public class Payment
{
    @Column(name="Name")
    private String Name;
    @Column(name="CardNumber")
    private String cardNumber;
    @Column(name="Expiry")
    private LocalDate expiryDate;
    @Column(name="cvv")
    private String cvv;
}