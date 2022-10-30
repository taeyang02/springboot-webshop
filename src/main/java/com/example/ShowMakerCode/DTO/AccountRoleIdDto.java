package com.example.ShowMakerCode.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.AccountRoleId} entity
 */
@Data
public class AccountRoleIdDto implements Serializable {
    private final Long accountId;
    private final Long roleId;
}