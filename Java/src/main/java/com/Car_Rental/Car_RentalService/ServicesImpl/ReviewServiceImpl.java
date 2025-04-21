package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Repositories.ReviewRepo;
import com.Car_Rental.Car_RentalService.Request.ReviewRequest;
import com.Car_Rental.Car_RentalService.Services.ReviewService;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.Review;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ProductServiceImpl prod_serv;
    private ReviewRepo rev_repo;

    public ReviewServiceImpl(ProductServiceImpl prod_serv, ReviewRepo rev_repo) {
        this.prod_serv = prod_serv;
        this.rev_repo = rev_repo;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product prod=prod_serv.findById(req.getProduct_id());
        if(prod==null)
            throw new ProductException("No such product exist");
        Review rev=new Review();
        rev.setReview(req.getReview());
        rev.setProduct(prod);
        rev.setUser(user);
        rev.setReviewedAt(LocalDateTime.now());
        rev_repo.save(rev);
        return rev;
    }

    @Override
    public List<Review> getAllReviews(Long product_id) {
        return rev_repo.findByProductId(product_id);
    }
}
