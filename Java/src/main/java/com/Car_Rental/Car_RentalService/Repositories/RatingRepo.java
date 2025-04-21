package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Long> {
    public List<Rating> findByProductId(Long id);
}
