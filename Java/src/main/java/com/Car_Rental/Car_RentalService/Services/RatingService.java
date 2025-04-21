package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Request.RatingRequest;
import com.Car_Rental.Car_RentalService.model.Rating;
import com.Car_Rental.Car_RentalService.model.User;

import java.util.List;

public interface RatingService {
    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getRating(Long product_id);
}
