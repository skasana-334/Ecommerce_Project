package com.Car_Rental.Car_RentalService.Controller;

import com.Car_Rental.Car_RentalService.Services.OrderService;
import com.Car_Rental.Car_RentalService.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired OrderService order_service;
    @PostMapping("/create")
    public void addOrder(@RequestBody Order order) {
        order_service.createOrder(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(order_service.getOrderById(id));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> orders = order_service.getUserOrders(userId);
        return ResponseEntity.ok(orders);
    }

    // 4️⃣ Update order status
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        boolean updated = order_service.updateOrderStatus(id, status);
        return updated ? ResponseEntity.ok("Order status updated successfully.")
                : ResponseEntity.notFound().build();
    }

    // 5️⃣ Cancel (delete) an order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean deleted = order_service.deleteOrder(id);
        return deleted ? ResponseEntity.ok("Order deleted successfully.")
                : ResponseEntity.notFound().build();
    }
}
