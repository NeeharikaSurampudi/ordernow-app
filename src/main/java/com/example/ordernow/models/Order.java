package com.example.ordernow.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private String type;
    private Boolean standingOrder;
    private LocalDate fromdate;
    private LocalDate todate;
    private Boolean mon;
    private Boolean tue;
    private Boolean wed;
    private Boolean thur;
    private Boolean fri;
    private Boolean sat;
    private String preference;

    @ManyToOne()
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private Customer customer;

}
