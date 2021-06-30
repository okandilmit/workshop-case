package com.pia.workshop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pia.workshop.model.FootballTeam;

public interface FootballTeamRepository extends MongoRepository<FootballTeam, UUID>{
	
	List<FootballTeam> findTeamByName(String name);		// Listelemek için
	List<FootballTeam> findAll();						// Listelemek için
	FootballTeam findByName(String name);				// Daha önce eklenmiş mi kontrolü için
	FootballTeam deleteTeamById(UUID id);				// Silmek için

}
