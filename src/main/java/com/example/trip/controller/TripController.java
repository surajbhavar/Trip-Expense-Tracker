package com.example.trip.controller;


import com.example.trip.entity.Trip;
import com.example.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "index";
    }

    @GetMapping("/addTrip")
    public String addTripForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "addTrip";
    }

    @PostMapping("/saveTrip")
    public String saveTrip(Trip trip) {
        tripService.saveTrip(trip);
        return "redirect:/";
    }

    @GetMapping("/viewTrips")
    public String viewTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "viewTrips";
    }
}
