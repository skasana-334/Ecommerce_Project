package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.Cart;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {
    @Query("select c from Cart c where c.user.user_id=:user_id")
    public Cart findByUserId(@Param("user_id") Long user_id);
}