package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}