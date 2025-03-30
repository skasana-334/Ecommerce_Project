package com.Car_Rental.Car_RentalService.Controller;

import com.Car_Rental.Car_RentalService.Services.ProductService;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // ✅ Use RestController instead of Controller
@RequestMapping("/products")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService prod_repo;

    @GetMapping("/getall")
    public List<Product> getAll() {
        return prod_repo.getAllProducts();
    }
//    @PostMapping ("/hello")
//    public ResponseEntity<User> sayHello(@RequestBody User user) {
//     User sample=new User();
//     sample.setUsername(user.getUsername());
//     sample.setPassword("hello");
////     return ResponseEntity.status(HttpStatus.OK).body(sample);
//        return ResponseEntity.ok(sample);
//    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return prod_repo.getProductById(id);
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product p) {
        return prod_repo.addProduct(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        prod_repo.deleteProduct(id);
    }
}
