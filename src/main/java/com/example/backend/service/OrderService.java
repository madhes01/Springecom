package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Order;
import com.example.backend.model.OrderItem;
import com.example.backend.model.Product;
import com.example.backend.model.dto.OrderItemRequest;
import com.example.backend.model.dto.OrderItemResponse;
import com.example.backend.model.dto.OrderRequest;
import com.example.backend.model.dto.OrderResponse;
import com.example.backend.repo.OrderRepo;
import com.example.backend.repo.ProductRepo;

@Service
public class OrderService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
       
        Order order = new Order();
        String orderID = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderID);
        order.setCustomerName(orderRequest.customerName());
        order.setEmail(orderRequest.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequest itemReq : orderRequest.items()) {
            
            Product product = productRepo.findById(itemReq.productId()).orElseThrow(() -> new RuntimeException("Product not found"));

            product.setStockQuantity(product.getStockQuantity() - itemReq.quantity());
            productRepo.save(product);

            OrderItem orderItem = OrderItem.builder()
                .product(product)
                .quantity(itemReq.quantity())
                .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemReq.quantity())))
                .order(order)
                .build();
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        Order savedOrder = orderRepo.save(order);


        List<OrderItemResponse> itemResponses = new ArrayList<>();
        for(OrderItem item : savedOrder.getOrderItems()) {
            OrderItemResponse itemResponse = new OrderItemResponse(
                item.getProduct().getName(),
                item.getQuantity(),
                item.getTotalPrice()
            );
            itemResponses.add(itemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
            savedOrder.getOrderId(), 
            savedOrder.getCustomerName(), 
            savedOrder.getEmail(), 
            savedOrder.getOrderDate(), 
            savedOrder.getStatus(), 
            itemResponses);
        // OrderResponse orderResponse = new OrderResponse(
        //     savedOrder.getOrderId(), 
        //     savedOrder.getCustomerName(), 
        //     savedOrder.getEmail(), 
        //     savedOrder.getStatus(), 
        //     savedOrder.getOrderDate(), 
        //     itemResponses);
        return orderResponse;
    }

    public List<OrderResponse> getAllOrderResponses() {
       

        List<Order> orders = orderRepo.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();

        for (Order order : orders) {
            List<OrderItemResponse> itemResponses = new ArrayList<>();
            for (OrderItem item : order.getOrderItems()) {
                OrderItemResponse itemResponse = new OrderItemResponse(
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice()
                );
                itemResponses.add(itemResponse);
            }
            OrderResponse orderResponse = new OrderResponse(
                order.getOrderId(),
                order.getCustomerName(),
                order.getEmail(),
                order.getOrderDate(),
                order.getStatus(),
                itemResponses
            );
            orderResponses.add(orderResponse);
        }

        return orderResponses;
    }



}
