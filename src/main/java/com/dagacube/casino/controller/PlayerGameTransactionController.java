package com.dagacube.casino.controller;

import com.dagacube.casino.dto.TransactionRequest;
import com.dagacube.casino.model.Player;
import com.dagacube.casino.model.Transaction;
import com.dagacube.casino.service.PlayerService;
import com.dagacube.casino.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerGameTransactionController {
    
    @Autowired
    PlayerService playerService;
    
    @Autowired
    TransactionService transactionService;
    
    //Get player balance
    @GetMapping("/players/balance/{playerId}")
    public ResponseEntity<Player> getPlayerById(@RequestBody @PathVariable Long playerId) {
        return new ResponseEntity<>(playerService.getBalanceByPlayerId(playerId), HttpStatus.OK);
    }
    

    //Wager  
    
    @PostMapping("/players/wager")
    public ResponseEntity<Transaction> wager(@RequestBody TransactionRequest transactionRequest) {
        return new ResponseEntity<>(transactionService.wager(transactionRequest), HttpStatus.OK);
    }
    
    
    //Win 

    @PostMapping("/players/win/{playerId}")
    public ResponseEntity<Transaction> win(@RequestBody TransactionRequest transactionRequest) {
        return new ResponseEntity<>(transactionService.win(transactionRequest), HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
}
