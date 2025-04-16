package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Repositories.CategoryRepo;
import com.Car_Rental.Car_RentalService.Repositories.ProductRepo;
import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.Request.ProductRequest;
import com.Car_Rental.Car_RentalService.Services.ProductService;
import com.Car_Rental.Car_RentalService.model.Category;
import com.Car_Rental.Car_RentalService.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepo prod_repo;
    UserRepo user_repo;
    CategoryRepo cat_repo;

    public ProductServiceImpl(ProductRepo prod_repo, UserRepo user_repo, CategoryRepo cat_repo) {
        this.prod_repo = prod_repo;
        this.user_repo = user_repo;
        this.cat_repo = cat_repo;
    }

    @Override
    public Product createProduct(ProductRequest req)  {
        Category cat=cat_repo.findByName(req.getCat());
        if(cat==null){
            cat=new Category();
            cat.setName(req.getCat());
            cat_repo.save(cat);
        }
        Product new_product=new Product();
        new_product.setCategory(cat);
        new_product.setName(req.getName());
        new_product.setPrice(req.getPrice());
        new_product.setSize(req.getSize());
        new_product.setColor(req.getColor());
        new_product.setDescription(req.getDescription());
        new_product.setQuantity(req.getQuantity());
        prod_repo.save(new_product);

    return new_product;
    }

    @Override
    public String deleteProduct(Long id) throws ProductException {
        Product product=prod_repo.findById(id).orElseThrow(()->new ProductException("No product found with id"+id));
        product.getSize().clear();
        prod_repo.delete(product);
        return "Product deleted successfully";
    }

    @Override
    public Product updateProduct(Long id,Product req) throws ProductException {
Product product=prod_repo.findById(id).orElseThrow(()->new ProductException("No product found with id"+id));
if(req.getPrice()!=0)
    product.setPrice(req.getPrice());
return prod_repo.save(product);


    }

    @Override
    public Product findById(Long id) throws ProductException {
        Optional<Product> op=prod_repo.findById(id);
        if(op.isPresent())
            return op.get();
        throw new ProductException("No product found with id"+id);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return List.of();
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> size, List<String> color, Integer minPrice, Integer maxPrice, String sort, String stock, Integer pageno, Integer pagesize) {
        Pageable pageble= PageRequest.of(pageno,pagesize);
        List<Product>prod=prod_repo.filterProducts(category, minPrice, maxPrice, sort);
        if(!color.isEmpty()){
            prod=prod.stream().filter(p->color.stream().anyMatch(c->c.equalsIgnoreCase(p.getColor())))
                    .collect(Collectors.toList());
        }
if(stock!=null){
    if(stock.equalsIgnoreCase("in_stock"))
        prod=prod.stream().filter(p->p.getQuantity()>0).collect(Collectors.toList());
    else
        prod=prod.stream().filter(p->p.getQuantity()<1).collect(Collectors.toList());
}

int start_idx=(int)pageble.getOffset();
int end_idx=Math.min(start_idx+ pageble.getPageSize(),prod.size());
List<Product>pageContent=prod.subList(start_idx,end_idx);
return new PageImpl<>(pageContent,pageble,prod.size());
    }
}
