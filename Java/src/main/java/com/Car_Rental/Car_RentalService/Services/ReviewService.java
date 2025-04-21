package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Request.ReviewRequest;
import com.Car_Rental.Car_RentalService.model.Review;
import com.Car_Rental.Car_RentalService.model.User;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReviews(Long product_id);
}
