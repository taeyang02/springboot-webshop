package com.example.ShowMakerCode.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCard {
    private Long id;
    private String createBy;
    private Instant createDate;
    private String modifiedBy;
    private Instant modifiedDate;
    private String description;
    private Byte available;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String size;
    private String image;
    private Integer quantitySold;
    private Category category;
}
