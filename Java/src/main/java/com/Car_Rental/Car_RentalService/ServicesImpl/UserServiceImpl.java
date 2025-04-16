package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Config.JwtProvider;
import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.Services.UserService;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo user_repo;
    private JwtProvider jwt_prov;

    public UserServiceImpl(UserRepo user_repo, JwtProvider jwt_prov) {
        this.user_repo = user_repo;
        this.jwt_prov = jwt_prov;
    }

    @Override
    public User findByid(Long user_id) throws UserException {
        Optional<User>user=user_repo.findById(user_id);
        if(user.isPresent())
            return user.get();
        throw  new UserException("No user exists with this id"+":"+user_id);
    }

    @Override
    public User findByJwt(String jwt) throws UserException {
      String email=jwt_prov.getEmailFromToken(jwt);
      User user=user_repo.findByEmail(email);
      if(user==null)
throw new UserException("No such email exists");
      return user;
    }
}
