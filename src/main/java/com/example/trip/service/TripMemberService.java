package com.example.trip.service;



import com.example.trip.entity.TripMember;
import com.example.trip.entity.Trip;
import com.example.trip.repository.TripMemberRepository;
import com.example.trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripMemberService {

    @Autowired
    private TripMemberRepository tripMemberRepository;

    @Autowired
    private TripRepository tripRepository;

    // Add a new member to a trip
    public void addMemberToTrip(Long tripId, TripMember member) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new RuntimeException("Trip not found"));
        member.setTrip(trip);
        tripMemberRepository.save(member);
    }

    // Get all members for a specific trip
    public List<TripMember> getMembersByTrip(Long tripId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new RuntimeException("Trip not found"));
        return trip.getMembers();
    }

    // Get a specific member by their ID
    public TripMember getMemberById(Long memberId) {
        return tripMemberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    // Delete a member by their ID
    public void deleteMemberById(Long memberId) {
        tripMemberRepository.deleteById(memberId);
    }
}
