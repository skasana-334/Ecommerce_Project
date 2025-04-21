package com.Car_Rental.Car_RentalService.Request;

public class ReviewRequest {
    private Long product_id;
    String review;
    public ReviewRequest(){}

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
