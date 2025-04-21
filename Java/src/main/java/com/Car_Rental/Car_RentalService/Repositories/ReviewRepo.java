package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
    public List<Review>findByProductId(Long ProductId);
}
