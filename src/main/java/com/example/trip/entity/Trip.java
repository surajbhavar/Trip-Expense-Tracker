package com.example.trip.entity;





import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<TripMember> members;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    // Getters and Setters
}

