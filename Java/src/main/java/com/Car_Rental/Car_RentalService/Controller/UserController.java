package com.Car_Rental.Car_RentalService.Controller;

import com.Car_Rental.Car_RentalService.DTO.UpdateUser;
import com.Car_Rental.Car_RentalService.Services.LoginService;
import com.Car_Rental.Car_RentalService.Services.UserService;
import com.Car_Rental.Car_RentalService.model.User;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService log_service;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
    @GetMapping("/login")
    public ResponseEntity<String> Login(@RequestBody User user){
        User check_username=log_service.checkUsername(user);
        User check_password=log_service.checkPassword(user);
        if(check_password!=null && check_username!=null)
            return ResponseEntity.ok("Login SuccessFul");
        else
            return ResponseEntity.ok("Login Failed");
    }
    @GetMapping("/getall")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PatchMapping ("/update/{id}")
    public ResponseEntity<String> UpdateUser(@PathVariable Long id, @RequestBody UpdateUser new_user){
         Boolean flag=userService.updateUser(id,new_user);
         if(flag)
             return ResponseEntity.ok("Ho Gya ji");
         else
             return ResponseEntity.ok("Nhi hua Gya ji");

    }

}
