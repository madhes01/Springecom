package com.example.backend.model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
    String orderId,
    String customerName,
    String email,
    LocalDate orderDate,
    String status,
    List<OrderItemResponse> items
) {

}
