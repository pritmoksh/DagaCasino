package com.dagacube.casino.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Long Id;
    
    private Long transactionId;
    
    private Long wager;
    
    private Long win;
    
    private Long balance;
    
    @CreationTimestamp
    private Date date;
    
    private Long playerId;
    
}
