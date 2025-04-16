package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.model.User;

public interface UserService {
    public User findByid(Long user_id) throws UserException;
    public User findByJwt(String jwt) throws UserException;
}
