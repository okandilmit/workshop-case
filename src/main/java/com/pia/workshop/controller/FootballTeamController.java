package com.pia.workshop.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pia.workshop.dto.FootballTeamDTO;
import com.pia.workshop.model.FootballTeam;
import com.pia.workshop.service.TeamService;

@RestController
@RequestMapping("/team")
public class FootballTeamController {

	@Autowired
	TeamService teamService;

	@PostMapping("/add-team")
	public FootballTeam addFootballTeam(@RequestBody FootballTeamDTO footballTeamDTO) {
		return teamService.addFootballTeam(footballTeamDTO);
	}
	
	@PostMapping("/update-team")	
	public FootballTeam updateFootballTeam(@RequestBody UUID id, FootballTeamDTO footballTeamDTO) {
		return teamService.updateFootballTeam(id, footballTeamDTO);
	}
	
	@PostMapping("/delete-team")	
	public FootballTeam deleteFootballTeam(@RequestBody UUID id) {
		return teamService.deleteFootballTeam(id);
	}
	
	@GetMapping("team-name/{name}")
	public List<FootballTeam> getTeamByName(@PathVariable("name") String name) {
		return teamService.findTeamByName(name);
	}
	
	@GetMapping("list-teams")
	public List<FootballTeam> getAllTeams() {
		return teamService.findAll();
	}

}
