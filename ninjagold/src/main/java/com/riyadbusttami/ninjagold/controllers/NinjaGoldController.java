package com.riyadbusttami.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Gold")
public class NinjaGoldController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("counter")==null) {
			session.setAttribute("counter", 0);
			session.setAttribute("activities", new ArrayList<ArrayList<String>>());
		}
		return "index.jsp";
	}
	@PostMapping("/process_money")
	public String process(@RequestParam("field") String field, HttpSession session) {
		Integer randInt=0;
		Random rand=new Random();
		ArrayList<String> message=new ArrayList<String>();
		SimpleDateFormat sdf= new SimpleDateFormat("MMMM dd yyyy, hh:mm a");
		if(field.equals("farm")) {
			randInt=rand.nextInt(10,20);
			
		}
		else if(field.equals("cave")) {
			randInt=rand.nextInt(5,10);
			
		}
		else if(field.equals("house")) {
			randInt=rand.nextInt(2,5);
			
		}
		else if(field.equals("quest")) {
			randInt=rand.nextInt(-50,50);
			
		}
		if(randInt>=0) {
			message.add("You entered a "+field+" and earned "+randInt+"("+sdf.format(new Date())+")");
			message.add("green");
		}
		else {
			message.add("You entered a "+field+" and lost "+randInt+"("+sdf.format(new Date())+")");
			message.add("red");		
		}
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<String>> messages=(ArrayList<ArrayList<String>>)session.getAttribute("activities");
		messages.add(0,message);
		session.setAttribute("activities", messages);
		session.setAttribute("counter", ((Integer)session.getAttribute("counter"))+randInt);
		
		return "redirect:/Gold";
	}
}
