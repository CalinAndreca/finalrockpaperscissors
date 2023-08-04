package org.fasttrackit.finalrockpaperscissors.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {
    PlayerScore findByPlayerName(String playerName);

    @Query("SELECT p FROM PlayerScore p ORDER BY p.rankingPoints DESC")
    List<PlayerScore> findAllByOrderByRankingPointsDesc();
}
