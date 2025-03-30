package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Repositories.LoginRepo;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepo log;
    public User checkUsername(User user){
        return log.findByUsername(user.getUsername(), user.getEmail());
    }
    public User checkPassword(User user){
        return log.findByPassword(user.getPassword());
    }
}
