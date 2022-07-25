package com.dagacube.casino.service.impl;

import com.dagacube.casino.exception.PlayerNotFoundException;
import com.dagacube.casino.model.Player;
import com.dagacube.casino.model.Transaction;
import com.dagacube.casino.repository.PlayerRepository;
import com.dagacube.casino.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PlayerImpl implements PlayerService {
    
    @Autowired
    PlayerRepository playerRepository;
    

    @Override
    public Player getBalanceByPlayerId(Long playerId) {
        Optional<Player> player = this.playerRepository.findById(playerId);
        if (player.isPresent()) {
            return playerRepository.getById(playerId);
        } else {
            throw new PlayerNotFoundException(HttpStatus.BAD_REQUEST, "Player not Found");
        }
    }
    
}