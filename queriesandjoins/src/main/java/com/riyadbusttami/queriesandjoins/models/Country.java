package com.riyadbusttami.queriesandjoins.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String name;
	private enum Continent {
		EUROPE,
		ASIA,
		AFRICA,
		NORTH_AMERICA,
		SOUTH_AMERICA,
		OCEANIA,
		ANTARCTICA
	}
	private Continent continent;
	private String region;
	private double surfaceArea;
	private short indepYear;
	private int population;
	private double lifeExpectancy;
	private double gnp;
	private double gnpOld;
	private String localName;
	private String governmentForm;
	private String headOfState;
	private int capital;
	private String code2;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cities;
	
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> languages;
	
	public Country() {
		
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public short getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(short indepYear) {
		this.indepYear = indepYear;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public double getGnp() {
		return gnp;
	}

	public void setGnp(double gnp) {
		this.gnp = gnp;
	}

	public double getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(double gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
}
