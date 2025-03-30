package com.Car_Rental.Car_RentalService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String paymentMethod;
    private String status;
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
