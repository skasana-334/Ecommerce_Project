package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.Request.AddItemRequest;
import com.Car_Rental.Car_RentalService.model.Cart;
import com.Car_Rental.Car_RentalService.model.User;

public interface cartService {
    public Cart createCart(User user);
    public String addItem(Long user_id, AddItemRequest req) throws ProductException, UserException;
    public Cart findUserCart(Long user_id);

}
