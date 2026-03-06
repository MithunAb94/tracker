package com.expense.tracker.contract;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
    private String title;
    private Double amount;
    private String category;
    private LocalDate date;
    private Long userId;
}
