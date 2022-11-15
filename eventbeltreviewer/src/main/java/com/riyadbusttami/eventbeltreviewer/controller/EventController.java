package com.riyadbusttami.eventbeltreviewer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riyadbusttami.eventbeltreviewer.models.Event;
import com.riyadbusttami.eventbeltreviewer.models.User;
import com.riyadbusttami.eventbeltreviewer.services.EventService;
import com.riyadbusttami.eventbeltreviewer.services.MessageService;
import com.riyadbusttami.eventbeltreviewer.services.UserService;


@Controller
@RequestMapping("/events")
public class EventController {
	@Autowired
	UserService userService;
	@Autowired
	MessageService messageService;
	@Autowired
	EventService eventService;
	
	@GetMapping("")
	public String index(HttpSession session, Model model)
	{
		if(session.getAttribute("userId")==null)return "redirect:/";
		else {
		User currUser=userService.get((Long)session.getAttribute("userId"));
		List<Event> allEvents = eventService.all();
		for(Event temp:allEvents) {
			temp.setIsOwner(currUser.getCreatedEvents().contains(temp));
			temp.setIsMember(currUser.getJoinedEvents().contains(temp));
		}
		model.addAttribute("allEvents", allEvents);
		model.addAttribute("event", new Event());
		return "/events/index.jsp";		
		}	
	}
	
	@PostMapping("")
	public String index(HttpSession session, @Valid @ModelAttribute("event")Event event, BindingResult result, Model model) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		if(result.hasErrors()) {
			User currUser=userService.get((Long)session.getAttribute("userId"));
			List<Event> allEvents = eventService.all();
			for(Event temp:allEvents) {
				temp.setIsOwner(currUser.getCreatedEvents().contains(temp));
				temp.setIsMember(currUser.getJoinedEvents().contains(temp));
			}
			model.addAttribute("allEvents", allEvents);			
			return "/events/index.jsp";	
		}
		else {
			eventService.create(event);
			return "redirect:/events";
		}
	}
	
	@PostMapping("/{id}/join")
	public String joinEvent(HttpSession session, @PathVariable("id")Long eventId) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		Event event = eventService.get(eventId);
		User currUser=userService.get((Long)session.getAttribute("userId"));
		event.getMembers().add(currUser);
		eventService.update(event);
		return "redirect:/events";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEvent(HttpSession session, @PathVariable("id")Long eventId) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		eventService.delete(eventId);
		return "redirect:/events";
	}
	
	@DeleteMapping("/{id}/leave")
	public String leaveEvent(HttpSession session, @PathVariable("id")Long eventId) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		Event event = eventService.get(eventId);
		User currUser=userService.get((Long)session.getAttribute("userId"));
		event.getMembers().remove(currUser);
		eventService.update(event);
		return "redirect:/events";
	}
	
	@GetMapping("/{id}/edit")
	public String editEvent(HttpSession session, @PathVariable("id")Long eventId,Model model) {
		Event event = eventService.get(eventId);
		User currUser=userService.get((Long)session.getAttribute("userId"));
		if(currUser==null)return "redirect:/";
		if(event.getOwner().getId()!=currUser.getId())return "redirect:/";
		model.addAttribute("event", eventService.get(eventId));
		return "/events/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String updateEvent(HttpSession session, @PathVariable("id")Long eventId, @ModelAttribute("event")Event eventToBe, BindingResult result) {
		Event event = eventService.get(eventId);
		User currUser=userService.get((Long)session.getAttribute("userId"));
		if(currUser==null)return "redirect:/";
		if(event.getOwner().getId()!=currUser.getId())return "redirect:/";
		if(result.hasErrors()) {
			return "/events/edit.jsp";
		}
		else {
			eventService.update(eventToBe);
			return "redirect:/events";
		}
	}

}
