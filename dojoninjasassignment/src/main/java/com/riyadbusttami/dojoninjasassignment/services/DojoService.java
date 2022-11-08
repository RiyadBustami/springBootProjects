package com.riyadbusttami.dojoninjasassignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.riyadbusttami.dojoninjasassignment.models.Dojo;
import com.riyadbusttami.dojoninjasassignment.repositories.DojoRepository;
@Service
public class DojoService {

	private DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository=dojoRepository;
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public List<Dojo> all(){
		return dojoRepository.findAll();
	}
	public void delete(Long id) {
		dojoRepository.deleteById(id);
	}

	public Dojo get(Long id) {
		Optional<Dojo> optionalDojo=dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}
