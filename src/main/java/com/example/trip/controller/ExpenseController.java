package com.example.trip.controller;

import com.example.trip.entity.Expense;
import com.example.trip.entity.Trip;
import com.example.trip.service.ExpenseService;
import com.example.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpenseController {
    @Autowired
    private TripService tripService;

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/addExpense")
    public String addExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("trips", tripService.getAllTrips());
        return "addExpense";
    }

    @PostMapping("/saveExpense")
    public String saveExpense(Expense expense) {
        expenseService.saveExpense(expense);
        return "redirect:/";
    }

    @GetMapping("/viewExpenses")
    public String viewExpenses(Long tripId, Model model) {
        Trip trip = tripService.getTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("expenses", trip.getExpenses());
        model.addAttribute("totalExpense", tripService.calculateTotalExpenses(trip));
        return "viewExpenses";
    }

    @GetMapping("/splitExpenses")
    public String splitExpenses(Long tripId, Model model) {
        Trip trip = tripService.getTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("members", trip.getMembers());
        return "splitExpenses";
    }
}
