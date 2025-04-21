package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Exception.UserException;
import com.Car_Rental.Car_RentalService.Exception.cartItemException;
import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.Repositories.cartItemsRepo;
import com.Car_Rental.Car_RentalService.Services.UserService;
import com.Car_Rental.Car_RentalService.Services.cartItemService;
import com.Car_Rental.Car_RentalService.model.Cart;
import com.Car_Rental.Car_RentalService.model.Product;
import com.Car_Rental.Car_RentalService.model.User;
import com.Car_Rental.Car_RentalService.model.cartItem;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class cartItemServiceImpl implements cartItemService {
    private cartItemsRepo cartItem_repo;
    private UserServiceImpl user_serv;

    public cartItemServiceImpl(cartItemsRepo cartItem_repo, UserServiceImpl user_repo) {
        this.cartItem_repo = cartItem_repo;
        this.user_serv = user_repo;
    }

    @Override
    public cartItem createCartItem(cartItem item) {
     cartItem new_item=new cartItem();
     new_item.setQuant(item.getQuant());
     new_item.setPrice(item.getProduct().getPrice()*new_item.getQuant());
     cartItem_repo.save(new_item);
     return new_item;
    }

    @Override
    public cartItem updateCartItem(Long user_id, Long cartItem_id, cartItem item) throws cartItemException, UserException {
      cartItem cart_item=findcartItemById(cartItem_id);
      User user=user_serv.findByid(cart_item.getUser_id());
      if(user_id.equals(user.getUser_id()))
      {
          cart_item.setQuant(item.getQuant());
          cart_item.setPrice(cart_item.getProduct().getPrice()*cart_item.getQuant());
      }
      cartItem_repo.save(cart_item);
      return cart_item;
    }

    @Override
    public cartItem findcartItem(Cart cart, Product product, String size, Long user_id) {
     return cartItem_repo.findCartItem(cart,product,size,user_id);

    }

    @Override
    public void removecartItem(Long user_id, Long cartItem_id) throws cartItemException, UserException {
cartItem item=findcartItemById(cartItem_id);
User user=user_serv.findByid(item.getUser_id());
if(user_id.equals(user.getUser_id())){
    cartItem_repo.deleteById(cartItem_id);
    return ;
}
throw new UserException("you can't remove another users item");
    }
    @Override
    public cartItem findcartItemById(Long cart_itemId) throws cartItemException{
        Optional<cartItem>item=cartItem_repo.findById(cart_itemId);
        if(item.isPresent())
            return item.get();
    throw new cartItemException("No such product is found");}
}
