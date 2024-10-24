package com.example.trip.service;



import com.example.trip.entity.Expense;
import com.example.trip.entity.Trip;
import com.example.trip.entity.TripMember;
import com.example.trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }

    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public BigDecimal calculateTotalExpenses(Trip trip) {
        return trip.getExpenses().stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateMemberShare(Trip trip, TripMember member) {
        BigDecimal totalExpenses = calculateTotalExpenses(trip);
        int numberOfMembers = trip.getMembers().size();
        return totalExpenses.divide(BigDecimal.valueOf(numberOfMembers), 2, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal calculateMemberOwe(Trip trip, TripMember member) {
        BigDecimal memberShare = calculateMemberShare(trip, member);
        BigDecimal memberPaid = trip.getExpenses().stream()
                .filter(expense -> expense.getPaidBy().equals(member))
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return memberShare.subtract(memberPaid);
    }
}
