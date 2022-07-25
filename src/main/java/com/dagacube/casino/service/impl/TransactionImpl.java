package com.dagacube.casino.service.impl;

import com.dagacube.casino.dto.TransactionRequest;
import com.dagacube.casino.exception.NotEnoughBalance;
import com.dagacube.casino.model.Player;
import com.dagacube.casino.model.Transaction;
import com.dagacube.casino.repository.PlayerRepository;
import com.dagacube.casino.repository.TransactionRepository;
import com.dagacube.casino.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TransactionImpl implements TransactionService {

    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    TransactionRepository transactionRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Transaction wager(TransactionRequest transactionRequest) {
        Optional<Player> player = getPlayer(transactionRequest);
        checkPlayerBalance(player);
        Transaction transaction = new Transaction();
        checkIfWagerGreaterThanBalance(transactionRequest, player);
        transaction.setWager(transactionRequest.getWager());
        checkTransactionID(transactionRequest);
        transaction.setTransactionId(transactionRequest.getTransactionId());
        transaction.setPlayerId(transactionRequest.getPlayerId());
        transaction.setDate(transactionRequest.getDate());
        transaction.setWin(transactionRequest.getWin());
        transaction.setBalance((player.get().getBalance() - transactionRequest.getWager()) + transactionRequest.getWin());
        playerRepository.findById(transactionRequest.getPlayerId()).get().setBalance(transaction.getBalance());
        return transactionRepository.save(transaction);
    }
    


    @Override
    public Transaction win(TransactionRequest transactionRequest) {
        Optional<Player> player = getPlayer(transactionRequest);
        checkPlayerBalance(player);
        Transaction transaction = new Transaction();
        checkIfWagerGreaterThanBalance(transactionRequest, player);
        transaction.setWager(transactionRequest.getWager());
        transaction.setTransactionId(transactionRequest.getTransactionId());
        transaction.setPlayerId(transactionRequest.getPlayerId());
        transaction.setDate(transactionRequest.getDate());
        transaction.setWin(transactionRequest.getWin());
        transaction.setBalance((player.get().getBalance() - transactionRequest.getWager()) + transactionRequest.getWin());
        return transactionRepository.save(transaction);
    }

    private void checkTransactionID(TransactionRequest transactionRequest) {
        if (transactionRepository.existsByTransactionId(transactionRequest.getTransactionId())) {
            throw new IllegalArgumentException("TransactionId already exists");
        }
    }
    private Optional<Player> getPlayer(TransactionRequest transactionRequest) {
        return playerRepository.findById(transactionRequest.getPlayerId());
    }
    
    private void checkPlayerBalance(Optional<Player> player) {
        if (player.isPresent() && player.get().getBalance() < 0) {
            throw new NotEnoughBalance(HttpStatus.I_AM_A_TEAPOT, "Player has no balance");
        }
    }

    private void checkIfWagerGreaterThanBalance(TransactionRequest transactionRequest, Optional<Player> player) {
        if (transactionRequest.getWager() > player.get().getBalance()) {
            throw new NotEnoughBalance(HttpStatus.INTERNAL_SERVER_ERROR,"Not enough balance");
        }
    }
    
    
}
