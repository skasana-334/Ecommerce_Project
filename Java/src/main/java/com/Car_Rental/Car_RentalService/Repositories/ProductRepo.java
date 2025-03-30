package com.Car_Rental.Car_RentalService.Repositories;

              /* Data Access Layer*/
import com.Car_Rental.Car_RentalService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//this repository is to provide ready made crud methods by extends JpaRepo
//if you want to do it manually then you can create an interface and write crud methods there and implement
//them in other class using Entity manager
@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{

}
