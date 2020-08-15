package com.example.ordernow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    private String name;
    private Long phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private Long pinCode;
    private String location;

//    @OneToMany(targetEntity=Order.class, mappedBy="orders",cascade= CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Order> orders;
}
