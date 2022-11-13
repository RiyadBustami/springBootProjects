package com.riyadbusttami.queriesandjoins.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String countryCode;
	private String language;
	private enum IsOfficial {
		T,
		F
	}
	private IsOfficial isOfficial;
	private double percentage;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
	
    public Language() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public IsOfficial getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(IsOfficial isOfficial) {
		this.isOfficial = isOfficial;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
   
}
