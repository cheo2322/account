package com.devsu.account.service.impl;

import com.devsu.account.entity.Account;
import com.devsu.account.entity.Movement;
import com.devsu.account.entity.dto.MovementRecord;
import com.devsu.account.handler.exception.EntityNotFoundException;
import com.devsu.account.handler.exception.IllegalMovementException;
import com.devsu.account.mapper.MovementMapper;
import com.devsu.account.repository.AccountRepository;
import com.devsu.account.repository.MovementRepository;
import com.devsu.account.service.MovementService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService {

  private final MovementRepository movementRepository;
  private final AccountRepository accountRepository;

  public MovementServiceImpl(
      MovementRepository movementRepository, AccountRepository accountRepository) {
    this.movementRepository = movementRepository;
    this.accountRepository = accountRepository;
  }

  @Override
  public void createMovement(MovementRecord movementRecord) {
    Optional<Account> accountByNumber =
        accountRepository.findByNumber(movementRecord.accountNumber());
    if (accountByNumber.isEmpty()) {
      throw new EntityNotFoundException("Account not found.");
    }

    Double movementValue = movementRecord.value();
    if (movementValue == 0) {
      throw new IllegalMovementException("Movement with value equal to zero.");
    }

    Optional<Movement> lastMovementDB = movementRepository.findTopByOrderByMovementDateDesc();
    if (lastMovementDB.isEmpty()) {
      throw new IllegalMovementException("No movements found.");
    }

    Movement lastMovement = lastMovementDB.get();
    Movement movement = MovementMapper.recordToMovement(movementRecord);

    if (movementValue < 0) {
      if (Math.abs(movementValue) > lastMovement.getBalance()) {
        throw new IllegalMovementException("Movement not allowed.");
      }

      movement.setType(Movement.MovementType.WITHDRAW);
    } else {
      movement.setType(Movement.MovementType.SAVE);
    }

    movement.setBalance(lastMovement.getBalance() + movementValue);
    movement.setAccount(accountByNumber.get());
  }

  @Override
  public List<MovementRecord> getMovements(String accountNumber, LocalDate start, LocalDate end) {
    return movementRepository
        .findByAccountNumberAndDateBetween(
            accountNumber, start.atStartOfDay(), end.atTime(LocalTime.MAX))
        .stream()
        .map(MovementMapper::movementToRecord)
        .collect(Collectors.toList());
  }
}
