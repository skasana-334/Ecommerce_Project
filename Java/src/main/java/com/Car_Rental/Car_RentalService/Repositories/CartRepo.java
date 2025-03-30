package com.Car_Rental.Car_RentalService.Repositories;

/* Data Access Layer*/
import com.Car_Rental.Car_RentalService.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> { }
