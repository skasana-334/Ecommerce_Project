package com.Car_Rental.Car_RentalService.Repositories;

import com.Car_Rental.Car_RentalService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE (:category IS NULL OR p.category.name = :category) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "AND (:stock IS NULL OR p.stock = :stock) " +
            "ORDER BY " +
            "CASE WHEN :sort = 'price_low' THEN p.price END ASC, " +
            "CASE WHEN :sort = 'price_high' THEN p.price END DESC")
    public List<Product>filterProducts(@Param("category") String category,
                                       @Param("minPrice") Integer minPrice,
                                       @Param("maxPrice") Integer maxPrice,
                                    @Param("sort") String sort
                                       );
}