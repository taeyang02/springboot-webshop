package com.example.ShowMakerCode.DTO;

import com.example.ShowMakerCode.Entity.Order;
import com.example.ShowMakerCode.Entity.Product;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.OrderDetail} entity
 */
@Data
public class OrderDetailDto implements Serializable {
    private final Long id;
    private final Integer quantity;
    private final BigDecimal price;
    private final Order order;
    private final Product product;
}