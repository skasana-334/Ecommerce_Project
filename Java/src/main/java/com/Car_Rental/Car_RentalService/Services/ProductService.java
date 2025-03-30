package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Repositories.ProductRepo;
import com.Car_Rental.Car_RentalService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*   Business Logic Layer*/
@Service
public class ProductService {
    @Autowired private ProductRepo prod_repo;
    public List<Product> getAllProducts(){
        return prod_repo.findAll();
    }
    public Product addProduct(Product product) {
        return prod_repo.save(product);
    }
    public Product getProductById(Long id) {
        return prod_repo.findById(id).orElse(null);  // ✅ Automatically available
    }

    // Delete product
    public void deleteProduct(Long id) {
        prod_repo.deleteById(id);  // ✅ Automatically available
    }

}
