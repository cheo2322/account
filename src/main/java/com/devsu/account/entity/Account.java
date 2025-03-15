package com.devsu.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String clientIdentification;

  @Column(unique = true)
  private String number;

  private AccountType type;
  private Long initialBalance;
  private Boolean state;

  public enum AccountType {
    SAVES,
    CHECKING
  }
}
