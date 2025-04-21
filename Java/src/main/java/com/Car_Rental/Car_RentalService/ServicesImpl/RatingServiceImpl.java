package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Repositories.RatingRepo;
import com.Car_Rental.Car_RentalService.Request.RatingRequest;
import com.Car_Rental.Car_RentalService.Services.ProductService;
import com.Car_Rental.Car_RentalService.Services.RatingService;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.Rating;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    private RatingRepo rating_repo;
    private ProductServiceImpl prod_serv;

    public RatingServiceImpl(RatingRepo rating_repo,ProductServiceImpl serv) {
        this.rating_repo = rating_repo;
        this.prod_serv=serv;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product prod=prod_serv.findById(req.getProductId());
        Rating rating =new Rating();
        rating.setRating(req.getRating());
        rating.setProduct(prod);
        rating.setUser(user);
        rating.setRatedAt(LocalDateTime.now());

        rating_repo.save(rating);
        return rating;
    }

    @Override
    public List<Rating> getRating(Long product_id) {
        return rating_repo.findByProductId(product_id);
    }
}
