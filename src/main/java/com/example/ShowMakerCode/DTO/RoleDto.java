package com.example.ShowMakerCode.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final Long id;
    private final String createBy;
    private final Instant createDate;
    private final String modifiedBy;
    private final Instant modifiedDate;
    private final String name;
}