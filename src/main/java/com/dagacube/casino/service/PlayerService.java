package com.dagacube.casino.service;

import com.dagacube.casino.dto.TransactionRequest;
import com.dagacube.casino.model.Player;
import com.dagacube.casino.model.Transaction;

public interface PlayerService {

    Player getBalanceByPlayerId(Long playerId);

   
}
