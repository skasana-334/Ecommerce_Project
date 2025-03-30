package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.DTO.UpdateUser;
import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.model.User;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired UserRepo user_repo;
    public User registerUser(User user) { return user_repo.save(user); }
    public List<User> getAllUsers() { return user_repo.findAll(); }
    public User getUserById(Long id) { return user_repo.findById(id).orElse(null); }
    public Boolean updateUser(Long id, UpdateUser new_user){
        User old_user=user_repo.findById(id).orElse(null);
        if(old_user==null)
            return false;
       if(new_user.getAddress()!=null)
           old_user.setAddress(new_user.getAddress());
        if(new_user.getUsername()!=null)
            old_user.setUsername(new_user.getUsername());
        if(new_user.getEmail()!=null)
            old_user.setEmail(new_user.getEmail());
        user_repo.save(old_user);
        return true;
    }

    public void deleteUser(Long id) { user_repo.deleteById(id); }
}
