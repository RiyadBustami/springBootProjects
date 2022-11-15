package com.riyadbusttami.eventbeltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyadbusttami.eventbeltreviewer.models.Event;
import com.riyadbusttami.eventbeltreviewer.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;
	
	public List<Event> all(){
		return eventRepository.findAll();
	}
	
	public Event get(Long id) {
		Optional<Event> opEvent = eventRepository.findById(id);
		if(opEvent.isPresent()) {
			return opEvent.get();
		}
		else {
			return null;
		}
	}
	
	public Event create(Event event) {
		return eventRepository.save(event);
	}
	
	public void delete(Long id) {
		eventRepository.deleteById(id);
	}
	
	public Event update(Event event) {
		Optional<Event> opEvent = eventRepository.findById(event.getId());
		if(opEvent.isPresent()) {
			return eventRepository.save(event);
		}
		else {
			return null;
		}
	}
}
