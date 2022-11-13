package com.riyadbusttami.queriesandjoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riyadbusttami.queriesandjoins.services.WorldService;
@RestController
public class WorldController {
	@Autowired
	WorldService worldService;
	@RequestMapping("/first")
	public List<Object[]> first() {
		List<Object[]> table = worldService.firstQuery();
		return table;
	}
	@RequestMapping("/second")
	public List<Object[]> second() {
		List<Object[]> table = worldService.secondQuery();
		return table;
	}
	@RequestMapping("/third")
	public List<Object[]> third() {
		List<Object[]> table = worldService.thirdQuery();
		return table;
	}
	@RequestMapping("/fourth")
	public List<Object[]> fourth() {
		List<Object[]> table = worldService.fourthQuery();
		return table;
	}
	@RequestMapping("/fifth")
	public List<Object[]> fifth() {
		List<Object[]> table = worldService.fifthQuery();
		return table;
	}
	@RequestMapping("/sixth")
	public List<Object[]> sixth() {
		List<Object[]> table = worldService.sixthQuery();
		return table;
	}
	@RequestMapping("/seventh")
	public List<Object[]> seventh() {
		List<Object[]> table = worldService.seventhQuery();
		return table;
	}
	@RequestMapping("/eighth")
	public List<Object[]> eighth() {
		List<Object[]> table = worldService.eighthQuery();
		return table;
	}
}
