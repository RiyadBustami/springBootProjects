package com.riyadbusttami.dojoninjasassignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.riyadbusttami.dojoninjasassignment.models.Ninja;
import com.riyadbusttami.dojoninjasassignment.repositories.NinjaRepository;
@Service
public class NinjaService {

	private NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository=ninjaRepository;
	}
	
	public List<Ninja> all(){
		return ninjaRepository.findAll();
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja get(Long id) {
		Optional<Ninja> optionalNinja=ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
			
		}
		else {
			return null;
		}
	}
	public void delete(Long id) {
		ninjaRepository.deleteById(id);
		
	}

}
