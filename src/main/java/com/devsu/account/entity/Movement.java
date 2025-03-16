package com.devsu.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "movement_date")
  private LocalDateTime date = LocalDateTime.now();

  @Enumerated(EnumType.STRING)
  private Account.AccountType type;

  @Column(name = "movement_value")
  private Double value;

  private Double balance;

  @ManyToOne
  @JoinColumn(name = "account_number", referencedColumnName = "number", nullable = false)
  private Account account;
}
