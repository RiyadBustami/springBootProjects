package com.riyadbusttami.safetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/expenses/edit/{id}")
	public String editExpense(@PathVariable("id") Long id ,Model model) {
		model.addAttribute("expense",expenseService.findExpense(id));
		return "edit.jsp";
		
	}
	
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense,BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
		
	}
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id ,Model model) {
		model.addAttribute("expense",expenseService.findExpense(id));
		return "show.jsp";
	}
	@DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		expenseService.deleteExpense(id);
		
		return "redirect:/expenses";
	}

}
