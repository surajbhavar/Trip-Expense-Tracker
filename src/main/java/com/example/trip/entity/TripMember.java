package com.example.trip.entity;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TripMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	private String name;

    public TripMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripMember(Long id, String name, Trip trip) {
		super();
		this.id = id;
		this.name = name;
		this.trip = trip;
	}

	@ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    // Getters and Setters
}
