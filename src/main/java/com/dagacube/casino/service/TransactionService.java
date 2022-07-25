package com.dagacube.casino.service;


import com.dagacube.casino.dto.TransactionRequest;
import com.dagacube.casino.model.Transaction;

public interface TransactionService {


    Transaction wager(TransactionRequest transactionRequest);

    Transaction win(TransactionRequest transactionRequest);
}
