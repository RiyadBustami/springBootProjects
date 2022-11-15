package com.riyadbusttami.eventbeltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyadbusttami.eventbeltreviewer.models.Message;
import com.riyadbusttami.eventbeltreviewer.repositories.MessageRepository;
@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepository;
	
	public List<Message> all(){
		return messageRepository.findAll();
	}
	
	public Message get(Long id) {
		Optional<Message> opMessage = messageRepository.findById(id);
		if(opMessage.isPresent()) {
			return opMessage.get();
		}
		else {
			return null;
		}
	}
	
	public Message create(Message message) {
		return messageRepository.save(message);
	}
	
	public void delete(Long id) {
		messageRepository.deleteById(id);
	}
	
	public Message update(Message message) {
		Optional<Message> opMessage = messageRepository.findById(message.getId());
		if(opMessage.isPresent()) {
			return messageRepository.save(message);
		}
		else {
			return null;
		}
	}

}
