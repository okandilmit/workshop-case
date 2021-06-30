package com.pia.workshop.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class FootballPlayer {
	
	@Id
	private UUID id;
	private String stringId;				// ID string
	private String name;			// Futbolcu Adı
	private String surname;			// Futbolcu Soyadı
	private String position;		// Oynadığı Pozisyon
	private boolean nationality;	// Uyruk: 0 Yerli, 1 Yabancı
	private int playerNumber;		// Forma Numarası
	private String teamName;		// Futbolcu Bulunduğu Takım Adi
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getStringId() {
		return stringId;
	}
	public void setStringId(String stringId) {
		this.stringId = stringId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public boolean isNationality() {
		return nationality;
	}
	public void setNationality(boolean nationality) {
		this.nationality = nationality;
	}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
