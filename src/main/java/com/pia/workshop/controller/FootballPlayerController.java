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

import com.pia.workshop.dto.FootballPlayerDTO;
import com.pia.workshop.model.FootballPlayer;
import com.pia.workshop.service.PlayerService;

@RestController
@RequestMapping("/player")
public class FootballPlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping("/add-player")
	public FootballPlayer addFootballPlayer(@RequestBody FootballPlayerDTO footballPlayerDTO) throws Exception {
		return playerService.addFootballPlayer(footballPlayerDTO);
	}
	
	@PostMapping("/update-player")	
	public FootballPlayer updateBFootballPlayer(@RequestBody UUID id, FootballPlayerDTO footballPlayerDTO) {
		return playerService.updateFootballPlayer(id, footballPlayerDTO);
	}
	
	@PostMapping("/delete-player")	
	public FootballPlayer deleteFootballPlayer(@RequestBody UUID id) {
		return playerService.deleteFootballPlayer(id);
	}
	
	@GetMapping("player-name/{stringId}")
	public List<FootballPlayer> getPlayerByStringId(@PathVariable("stringId") String stringId) {
		return playerService.findPlayerByStringId(stringId);
	}
	
	@GetMapping("team-players-name/{teamName}")
	public List<FootballPlayer> getPlayerByTeamName(@PathVariable("teamName") String teamName) {
		return playerService.findPlayerByTeamName(teamName);
	}

}
