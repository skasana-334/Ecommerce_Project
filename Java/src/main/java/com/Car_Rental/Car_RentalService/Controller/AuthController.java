package com.Car_Rental.Car_RentalService.Controller;

import com.Car_Rental.Car_RentalService.Config.JwtProvider;
import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.Request.LoginRequest;
import com.Car_Rental.Car_RentalService.Response.AuthResponse;
import com.Car_Rental.Car_RentalService.ServicesImpl.AuthUserServiceImpl;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserRepo repo;
    private JwtProvider jwtProvider;
    private PasswordEncoder pass;
    private AuthUserServiceImpl userService;

    public AuthController(UserRepo repo, JwtProvider jwtProvider, PasswordEncoder pass, AuthUserServiceImpl userService) {
        this.repo = repo;
        this.jwtProvider = jwtProvider;
        this.pass = pass;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse>createUserHandler(@RequestBody User user) throws UserException{
        String email=user.getEmail();
        String password= user.getPassword();
        String first= user.getFirstName();
        String last= user.getLastName();
        if(repo.findByEmail(email)!=null)
            throw new UserException("Email already exists");
        User createdUser=new User();
        createdUser.setEmail(email);
        createdUser.setPassword(pass.encode(password));
        createdUser.setFirstName(first);
        createdUser.setLastName(last);
        User savedUser=repo.save(createdUser);
        Authentication authentication=new UsernamePasswordAuthenticationToken(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtProvider.generateToken(authentication);
        AuthResponse response=new AuthResponse();
        response.setJwt(token);
        response.setMsg("Sign up Successful");
        return new ResponseEntity<AuthResponse>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse>loginUserHandler(@RequestBody LoginRequest req) throws UserException{
        String username=req.getEmail();
        String password=req.getPassword();
        Authentication auth=authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String token=jwtProvider.generateToken(auth);
        AuthResponse response=new AuthResponse();
        response.setJwt(token);
        response.setMsg("login Successful");
        return new ResponseEntity<AuthResponse>(response,HttpStatus.CREATED);
    }

    private Authentication authenticate(String username, String password) {
UserDetails temp=userService.loadUserByUsername(username);
if(temp==null||!pass.matches(password, temp.getPassword()))
    throw new BadCredentialsException("Invalid Credentails...");
return new UsernamePasswordAuthenticationToken(username,password);
    }
}
