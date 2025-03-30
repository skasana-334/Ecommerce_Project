//package com.Car_Rental.Car_RentalService.Controller;
//
//import com.Car_Rental.Car_RentalService.Services.LoginService;
//import com.Car_Rental.Car_RentalService.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class LoginController {
//@Autowired
//    LoginService log_service;
//    @GetMapping("/login")
//    public ResponseEntity<String> Login(@RequestBody User user){
//       User check_username=log_service.checkUsername(user);
//        User check_password=log_service.checkPassword(user);
//        if(check_password!=null && check_username!=null)
//            return ResponseEntity.ok("Login SuccessFul");
//        else
//            return ResponseEntity.ok("Login Failed");
//    }
//}
