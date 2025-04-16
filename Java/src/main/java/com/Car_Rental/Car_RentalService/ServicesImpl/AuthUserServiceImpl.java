package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserServiceImpl implements UserDetailsService {
    //here we are loading the user in security context
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
     User user=repo.findByEmail(userName);
     if(user==null)
         throw new UsernameNotFoundException(userName+"does not exist");
       List<GrantedAuthority>auth=new ArrayList<>();
       return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),auth);
   }
}
