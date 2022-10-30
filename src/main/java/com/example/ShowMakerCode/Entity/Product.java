package com.example.ShowMakerCode.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Instant modifiedDate;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "available", nullable = false)
    private Byte available;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price", nullable = false, precision = 20)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "size")
    private  String size;

    @Column(name = "image", length = 45)
    private String image;

    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;



}