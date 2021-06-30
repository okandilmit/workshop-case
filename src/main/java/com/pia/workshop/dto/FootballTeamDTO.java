package com.pia.workshop.dto;

import lombok.Data;

@Data
public class FootballTeamDTO {

	private String name;			// Futbolcu Adı
	private String league;			// Bulunuğu Lig
	private String logoUrl;			// Takım Logosu Linki
	private String city;			// Takımın Bulunduğu Şehir
	private int yearFounded;		// Takımın Kurulduğu Yıl
	private String colors;			// Takımın Renkleri
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	
	
	
}