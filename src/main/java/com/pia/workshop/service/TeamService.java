package com.pia.workshop.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pia.workshop.dto.FootballTeamDTO;
import com.pia.workshop.model.FootballTeam;
import com.pia.workshop.repository.FootballTeamRepository;

@Service
public class TeamService {
	@Autowired FootballTeamRepository footballTeamRepository;
	
	public FootballTeam addFootballTeam(FootballTeamDTO footballTeamDto) {
		
		FootballTeam footballTeamExist = footballTeamRepository.findByName(footballTeamDto.getName());
		if(Objects.nonNull(footballTeamExist)) {
        	throw new RuntimeException("Football Team exist"); 
		}
		
		FootballTeam footballTeam = new FootballTeam();
		footballTeam.setId(UUID.randomUUID());
		footballTeam.setName(footballTeamDto.getName());
		footballTeam.setLeague(footballTeamDto.getLeague());
		footballTeam.setLogoUrl(footballTeamDto.getLogoUrl());
		footballTeam.setCity(footballTeamDto.getCity());
		footballTeam.setYearFounded(footballTeamDto.getYearFounded());
		footballTeam.setColors(footballTeamDto.getColors());
		
		FootballTeam newFootballTeam = footballTeamRepository.save(footballTeam);		
		return newFootballTeam;		
	}
	
	public FootballTeam updateFootballTeam(UUID id, FootballTeamDTO footballTeamDto) {
		
		FootballTeam footballTeam = new FootballTeam();
		
		footballTeam.setId(id);
		footballTeam.setName(footballTeamDto.getName());
		footballTeam.setLeague(footballTeamDto.getLeague());
		footballTeam.setLogoUrl(footballTeamDto.getLogoUrl());
		footballTeam.setCity(footballTeamDto.getCity());
		footballTeam.setYearFounded(footballTeamDto.getYearFounded());
		footballTeam.setColors(footballTeamDto.getColors());
		
		FootballTeam newFootballTeam = footballTeamRepository.save(footballTeam);		
		return newFootballTeam;		
	}
	
	public FootballTeam deleteFootballTeam(UUID id) {
	    footballTeamRepository.deleteTeamById(id);		
		return null;
	}
	
	public List<FootballTeam> findTeamByName(String name) {
		return footballTeamRepository.findTeamByName(name);
	}
	
	public List<FootballTeam> findAll() {
		return footballTeamRepository.findAll();
	}
	
}
