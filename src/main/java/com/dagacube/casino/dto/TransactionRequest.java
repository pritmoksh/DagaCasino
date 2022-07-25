package com.dagacube.casino.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Data
public class TransactionRequest {

    private Long transactionId;

    private Long wager;

    private Long win;

    private Long balance;

    @CreationTimestamp
    private Date date;

    private Long playerId;
    
}
