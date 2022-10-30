package com.example.ShowMakerCode.DTO;

import com.example.ShowMakerCode.Entity.AccountRoleId;
import com.example.ShowMakerCode.Entity.Role;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.AccountRole} entity
 */
@Data
public class AccountRoleDto implements Serializable {
    private final AccountRoleId id;
    private final AccountDto account;
    private final Role role;
}