package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.Cart;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.cartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface cartItemsRepo extends JpaRepository<cartItem,Long> {
    @Query("SELECT c FROM cartItem c WHERE c.cart = :cart AND c.product = :product AND c.size = :size AND c.user_id = :userId")
    cartItem findCartItem(@Param("cart") Cart cart,
                          @Param("product") Product product,
                          @Param("size") String size,
                          @Param("userId") Long userId);

}