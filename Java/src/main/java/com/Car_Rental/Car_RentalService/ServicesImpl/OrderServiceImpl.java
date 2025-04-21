package com.Car_Rental.Car_RentalService.ServicesImpl;

import com.Car_Rental.Car_RentalService.Exception.OrderException;
import com.Car_Rental.Car_RentalService.Repositories.OrderRepo;
import com.Car_Rental.Car_RentalService.Services.OrderService;
import com.Car_Rental.Car_RentalService.model.Address;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepo order_repo;
    @Override
    public Order createOrder(User user, Address shippingAddress) {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long userId) {
        return List.of();
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public void deleteOrder(Long order_id) throws OrderException {

    }
}