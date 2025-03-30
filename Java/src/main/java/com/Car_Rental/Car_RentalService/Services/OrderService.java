package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Repositories.OrderRepo;
import com.Car_Rental.Car_RentalService.Repositories.UserRepo;
import com.Car_Rental.Car_RentalService.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderService {
    @Autowired OrderRepo order_repo;

    public void createOrder(Order order) {
        order_repo.save(order);
    }

    public Order getOrderById(Long id) {
        return order_repo.findById(id).orElse(null);
    }


    // Get all orders for a specific user
    public List<Order> getUserOrders(Long userId) {
        return order_repo.findByUserId(userId);
    }

    // Update order status
    public boolean updateOrderStatus(Long id, String status) {
        if (order_repo.existsById(id)) {
            order_repo.updateOrderStatus(id, status);
            return true;
        }
        return false;
    }

    // Delete (cancel) an order
    public boolean deleteOrder(Long id) {
        if (order_repo.existsById(id)) {
            order_repo.deleteById(id);
            return true;
        }
        return false;
    }
}
