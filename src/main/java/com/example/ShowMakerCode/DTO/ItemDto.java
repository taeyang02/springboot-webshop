package com.example.ShowMakerCode.DTO;

import com.example.ShowMakerCode.Entity.Category;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.Product} entity
 */
@Getter
@Setter
public class ItemDto implements Serializable {
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
    private String image;
    private Integer quantitySold;
    private Category category;

    public ItemDto(Long id, String createBy, Instant createDate, String modifiedBy, Instant modifiedDate, String description, Byte available, String name, BigDecimal price, Integer quantity, String image, Integer quantitySold, Category category) {
        this.id = id;
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.description = description;
        this.available = available;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.quantitySold = quantitySold;
        this.category = category;
    }

    public ItemDto() {
    }
}