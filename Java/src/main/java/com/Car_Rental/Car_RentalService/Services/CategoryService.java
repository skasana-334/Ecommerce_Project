package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Repositories.CategoryRepo;
import com.Car_Rental.Car_RentalService.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category addCategory(Category category) { return categoryRepo.save(category); }

    public List<Category> getAllCategories() { return categoryRepo.findAll(); }

    public Category getCategoryById(Long id) { return categoryRepo.findById(id).orElse(null); }

    public void deleteCategory(Long id) { categoryRepo.deleteById(id); }
}
