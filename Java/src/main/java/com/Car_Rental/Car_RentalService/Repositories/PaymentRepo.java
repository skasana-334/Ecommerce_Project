package com.Car_Rental.Car_RentalService.Repositories;

/* Data Access Layer*/
import com.Car_Rental.Car_RentalService.model.OrderItem;
import com.Car_Rental.Car_RentalService.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> { }
