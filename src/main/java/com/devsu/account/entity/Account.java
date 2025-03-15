package com.devsu.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String clientIdentification;

  @Column(unique = true)
  private String number;

  @Enumerated(EnumType.STRING)
  private AccountType type;

  private Long initialBalance;
  private Boolean status;

  public enum AccountType {
    SAVES,
    CHECKING
  }
}
