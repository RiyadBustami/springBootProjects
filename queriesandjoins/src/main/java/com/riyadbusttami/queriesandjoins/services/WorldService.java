package com.riyadbusttami.queriesandjoins.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyadbusttami.queriesandjoins.repositories.CountryRepository;

@Service
public class WorldService {
	@Autowired
	CountryRepository countryRepository;
	
	public List<Object[]> firstQuery(){
    	return countryRepository.firstQuery();
    }
	public List<Object[]> secondQuery(){
    	return countryRepository.secondQuery();
    }
	public List<Object[]> thirdQuery(){
    	return countryRepository.thirdQuery();
    }
	public List<Object[]> fourthQuery(){
    	return countryRepository.fourthQuery();
    }
	public List<Object[]> fifthQuery(){
    	return countryRepository.fifthQuery();
    }
	public List<Object[]> sixthQuery(){
    	return countryRepository.sixthQuery();
    }
	public List<Object[]> seventhQuery(){
    	return countryRepository.seventhQuery();
    }
	public List<Object[]> eighthQuery(){
    	return countryRepository.eighthQuery();
    }
 

}
