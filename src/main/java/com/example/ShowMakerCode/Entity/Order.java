package com.example.ShowMakerCode.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "`order`")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "create_by", length = 45)
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modified_by", length = 45)
    private String modifiedBy;

    @Column(name = "modified_date")
    private Instant modifiedDate;
    @Column(name = "status")
    private Byte status;



}