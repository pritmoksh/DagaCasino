package com.dagacube.casino.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "player")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Player {
    @Id
    @GeneratedValue
    private Long playerId;
    
    private String username;
    
    private Long balance;
    
}
