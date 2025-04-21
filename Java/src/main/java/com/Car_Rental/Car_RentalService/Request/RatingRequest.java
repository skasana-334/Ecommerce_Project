package com.Car_Rental.Car_RentalService.Request;

public class RatingRequest {
    private Long id;
    private double rating;
    public RatingRequest(){}

    public Long getProductId() {
        return id;
    }

    public void setProductId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
