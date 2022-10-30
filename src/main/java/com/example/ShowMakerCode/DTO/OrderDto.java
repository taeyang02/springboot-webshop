package com.example.ShowMakerCode.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.Order} entity
 */
@Data
public class OrderDto implements Serializable {
    private final Long id;
    private final String address;
    private final String phoneNumber;
    private final String createBy;
    private final Instant createDate;
    private final String modifiedBy;
    private final Instant modifiedDate;
}