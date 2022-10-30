package com.example.ShowMakerCode.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.ShowMakerCode.Entity.Account} entity
 */
@Data
public class AccountDto implements Serializable {
    private final Long id;
    private final String createBy;
    private final Instant createDate;
    private final String modifiedBy;
    private final Instant modifiedDate;
    private final String address;
    private final LocalDate dob;
    private final String email;
    private final String fullname;
    private final Byte gender;
    private final String password;
    private final String phoneNumber;
    private final Byte status;
    private final String username;
}