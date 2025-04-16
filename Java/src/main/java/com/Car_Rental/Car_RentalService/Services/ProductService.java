package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Request.ProductRequest;
import com.Car_Rental.Car_RentalService.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product createProduct(ProductRequest req);
    public String deleteProduct(Long id) throws ProductException;
    public Product updateProduct(Long id,Product product) throws ProductException;
    public Product findById(Long id) throws ProductException;
    public List<Product> findByCategory(String category);


    Page<Product> getAllProduct(String category, List<String> size, List<String> color, Integer minPrice, Integer maxPrice, String sort, String stock, Integer pageno, Integer pagesize);
}
