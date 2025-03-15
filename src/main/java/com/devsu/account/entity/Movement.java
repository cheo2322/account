package com.devsu.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Movement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "movement_date")
  private LocalDateTime date;

  @Enumerated(EnumType.STRING)
  private MovementType type;

  @Column(name = "movement_value")
  private Long value;

  private Long balance;

  @ManyToOne
  @JoinColumn(name = "account_number", referencedColumnName = "number", nullable = false)
  private Account account;

  public enum MovementType {
    SAVE,
    WITHDRAW
  }
}
