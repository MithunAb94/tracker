package com.expense.tracker.service;

import com.expense.tracker.contract.ExpenseRequest;
import com.expense.tracker.model.Expense;
import com.expense.tracker.model.User;
import com.expense.tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserService userService;

    public Expense addExpense(ExpenseRequest request){

        User user=userService.getUserById(request.getUserId());

        Expense expense=new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpenses(Long userId){
        return expenseRepository.findByUserId(userId);
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
}
