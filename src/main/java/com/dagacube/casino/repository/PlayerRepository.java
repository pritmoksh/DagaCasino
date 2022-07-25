package com.dagacube.casino.repository;

import com.dagacube.casino.model.Player;
import com.dagacube.casino.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Transaction getWagerByPlayerId(Long playerId);
}
