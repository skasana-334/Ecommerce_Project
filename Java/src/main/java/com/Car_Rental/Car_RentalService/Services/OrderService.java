package com.Car_Rental.Car_RentalService.Services;

import com.Car_Rental.Car_RentalService.Exception.OrderException;
import com.Car_Rental.Car_RentalService.model.Address;
import com.Car_Rental.Car_RentalService.model.User;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long userId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;
    public List<Order>getAllOrders();
    public void deleteOrder(Long order_id) throws OrderException;

}
