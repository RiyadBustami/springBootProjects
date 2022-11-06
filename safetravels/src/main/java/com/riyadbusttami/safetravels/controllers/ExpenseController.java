package com.riyadbusttami.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.riyadbusttami.safetravels.models.Expense;
import com.riyadbusttami.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	private ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService=expenseService;
	}
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, BindingResult result,Model model) {
		if(expenseService.allExpenses()!=null) {
			model.addAttribute("expenses",expenseService.allExpenses());
		}
		return "index.jsp";
	}
	@PostMapping("/expenses")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses",expenseService.allExpenses());
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
		
	}

}
