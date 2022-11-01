package com.riyadbusttami.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/your_server")
	public String increaseCount(HttpSession session) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count=(Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "welcome.jsp";
	}
	@RequestMapping("/your_server/counter")
	public String counterView(HttpSession session) {
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		return "counter.jsp";
	}
}
