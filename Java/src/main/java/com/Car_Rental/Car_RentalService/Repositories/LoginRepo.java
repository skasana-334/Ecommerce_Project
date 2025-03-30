package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<User,Long> {
    @Query("Select u From User u where u.username=:name or u.email=:email")
     User findByUsername (@Param("name") String name,@Param("email") String email);
    @Query("Select u From User u where u.password=:password")
    User findByPassword (@Param("password") String password);
}
