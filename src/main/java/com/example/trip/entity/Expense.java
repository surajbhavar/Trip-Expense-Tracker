package com.example.trip.entity;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private TripMember paidBy;

    public BigDecimal splitAmount() {
        int numberOfMembers = trip.getMembers().size();
        return amount.divide(BigDecimal.valueOf(numberOfMembers), 2, BigDecimal.ROUND_HALF_EVEN);
    }

    // Getters and Setters
}

