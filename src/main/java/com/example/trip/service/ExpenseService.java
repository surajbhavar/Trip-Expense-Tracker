package com.example.trip.service;



import com.example.trip.entity.Expense;
import com.example.trip.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}
