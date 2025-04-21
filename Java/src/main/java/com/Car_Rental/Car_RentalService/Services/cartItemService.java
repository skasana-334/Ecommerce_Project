package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.Exception.cartItemException;
import com.Car_Rental.Car_RentalService.model.Cart;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.cartItem;

public interface cartItemService {
    public cartItem createCartItem(cartItem item);
    public cartItem updateCartItem(Long user_id,Long cartItem_id,cartItem cartItem) throws cartItemException, UserException;
    public cartItem findcartItem(Cart cart, Product product,String size,Long user_id);
    public void removecartItem(Long user_id,Long cartItem_id) throws cartItemException,UserException;
    public cartItem findcartItemById(Long id) throws cartItemException;
}
