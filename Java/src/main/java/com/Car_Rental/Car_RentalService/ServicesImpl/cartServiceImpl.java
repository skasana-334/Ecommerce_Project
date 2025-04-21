package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Exception.ProductException;
import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.Repositories.CartRepo;
import com.Car_Rental.Car_RentalService.Request.AddItemRequest;
import com.Car_Rental.Car_RentalService.Services.UserService;
import com.Car_Rental.Car_RentalService.Services.cartService;
import com.Car_Rental.Car_RentalService.model.Cart;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.User;
import com.Car_Rental.Car_RentalService.model.cartItem;
import org.springframework.stereotype.Service;

@Service
public class cartServiceImpl implements cartService {
    private CartRepo cart_repo;
    private cartItemServiceImpl cartItems_serv;
    private ProductServiceImpl prod_serv;
    private UserServiceImpl user_serv;

    public cartServiceImpl(CartRepo cart_repo, cartItemServiceImpl cartItems_serv, ProductServiceImpl prod_serv,UserServiceImpl user_serv) {
        this.cart_repo = cart_repo;
        this.cartItems_serv = cartItems_serv;
        this.prod_serv = prod_serv;
        this.user_serv=user_serv;
    }

    @Override
    public Cart createCart(User user) {
 Cart newCart=new Cart();
 newCart.setUser(user);
 return cart_repo.save(newCart);
    }

    @Override
    public String addItem(Long user_id, AddItemRequest req) throws ProductException,UserException {
        Cart cart=cart_repo.findByUserId(user_id);
        Product product = prod_serv.findById(req.getProduct_id());
        cartItem item=cartItems_serv.findcartItem(cart,product,req.getSize(),user_id);
          if(item!=null){
         item.setQuant(req.getQuantity());
         item.setPrice(item.getQuant()*item.getProduct().getPrice());
         cartItems_serv.updateCartItem(user_id,item.getId(),item);
          }
        item = new cartItem();
        item.setCart(cart);
        item.setUser_id(user_id);
        item.setProduct(product);
        item.setSize(req.getSize());
        item.setQuant(req.getQuantity()); // default quantity
        item.setPrice(product.getPrice() * item.getQuant());

        cartItems_serv.createCartItem(item);
     cart.getCartItems().add(item);
        return "Item added to cart successfully!";
    }

    @Override
    public Cart findUserCart(Long user_id) {
        Cart cart=cart_repo.findByUserId(user_id);
        double totalPrice=0;
        int totalItems=0;
        for(cartItem item: cart.getCartItems()){
            totalPrice+=item.getPrice();
            totalItems+=1;
        }
        cart.setTotal_price(totalPrice);
        cart.setTotalItem(totalItems);
        return cart_repo.save(cart);
    }
}
