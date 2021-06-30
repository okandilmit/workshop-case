package com.pia.workshop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pia.workshop.dto.FootballPlayerDTO;
import com.pia.workshop.model.FootballPlayer;
import com.pia.workshop.repository.FootballPlayerRepository;

@Service
public class PlayerService {
	@Autowired FootballPlayerRepository footballPlayerRepository;

	public FootballPlayer addFootballPlayer(FootballPlayerDTO footballPlayerDto) throws Exception {
		
		Long maxPlayerCount = footballPlayerRepository.countByTeamName(footballPlayerDto.getTeamName());
		if(maxPlayerCount >= 18) {
        	throw new Exception("Team Full"); 
		}
		
		Long maxGoalkeeperCount = footballPlayerRepository.countByTeamNameAndPosition(footballPlayerDto.getTeamName(), "Kaleci");
		if(footballPlayerDto.getPosition().equalsIgnoreCase("Kaleci") && maxGoalkeeperCount >= 2) {
        	throw new Exception("Goalkeeper Position Full"); 
		}
		
		Long maxForeignerCount = footballPlayerRepository.countByTeamNameAndNationality(footballPlayerDto.getTeamName(), true);
		if(footballPlayerDto.isNationality() && maxForeignerCount >= 6) {
        	throw new Exception("Foreigner Position Full"); 
		}
		
		FootballPlayer footballPlayer = new FootballPlayer();
		
		UUID createID = UUID.randomUUID();
		footballPlayer.setId(createID);
		footballPlayer.setStringId(createID.toString());
		footballPlayer.setName(footballPlayerDto.getName());
		footballPlayer.setSurname(footballPlayerDto.getSurname());
		footballPlayer.setPosition(footballPlayerDto.getPosition());
		footballPlayer.setNationality(footballPlayerDto.isNationality());
		footballPlayer.setPlayerNumber(footballPlayerDto.getPlayerNumber());
		footballPlayer.setTeamName(footballPlayerDto.getTeamName());
		
		FootballPlayer newFootballPlayer = footballPlayerRepository.save(footballPlayer);		
		return newFootballPlayer;		
	}
	
	public FootballPlayer updateFootballPlayer(UUID id, FootballPlayerDTO footballPlayerDto) {
		
		FootballPlayer footballPlayer = new FootballPlayer();
		
		footballPlayer.setId(id);
		footballPlayer.setStringId(id.toString());
		footballPlayer.setName(footballPlayerDto.getName());
		footballPlayer.setSurname(footballPlayerDto.getSurname());
		footballPlayer.setPosition(footballPlayerDto.getPosition());
		footballPlayer.setNationality(footballPlayerDto.isNationality());
		footballPlayer.setPlayerNumber(footballPlayerDto.getPlayerNumber());
		footballPlayer.setTeamName(footballPlayerDto.getTeamName());
		
		FootballPlayer newFootballPlayer = footballPlayerRepository.save(footballPlayer);		
		return newFootballPlayer;		
	}
	
	public FootballPlayer deleteFootballPlayer(UUID id) {
		
	    footballPlayerRepository.deletePlayerById(id);		
		return null;
	}
	
	public List<FootballPlayer> findPlayerByStringId(String stringId) {
		return footballPlayerRepository.findPlayerByStringId(stringId);
	}
	
	public List<FootballPlayer> findPlayerByTeamName(String teamName) {
		return footballPlayerRepository.findPlayerByTeamName(teamName);
	}
}
