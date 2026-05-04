package com.example.backend.model.dto;


public record OrderItemRequest(
    int productId,
    int quantity
) {

}
