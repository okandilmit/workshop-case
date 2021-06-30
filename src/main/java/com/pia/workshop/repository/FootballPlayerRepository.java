package com.pia.workshop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pia.workshop.model.FootballPlayer;

public interface FootballPlayerRepository extends MongoRepository<FootballPlayer, UUID>{
	
	List<FootballPlayer> findPlayerByStringId(String stringId);		// Listelemek için
	List<FootballPlayer> findPlayerByTeamName(String teamName);			// Listelemek için
	FootballPlayer deletePlayerById(UUID id);						// Silmek için
	Long countByTeamName(String teamName);								// Aynı takımdaki oyuncu sayısı
	Long countByTeamNameAndPosition(String teamName, String position);							// Aynı pozisyondaki oyuncu sayısı
	Long countByTeamNameAndNationality(String teamName, boolean nationality);							// Aynı pozisyondaki oyuncu sayısı


}
