package com.riyadbusttami.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DateTimeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		String dateStr = sdf.format(date);
		model.addAttribute("date",dateStr);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("hh:mm a");
		String timeStr=sdf.format(date);
		model.addAttribute("time",timeStr);
		return "time.jsp";
	}
}
