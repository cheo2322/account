package com.devsu.account.service;

import com.devsu.account.entity.dto.MovementRecord;
import java.time.LocalDate;
import java.util.List;

/** Service for movements. */
public interface MovementService {

  /**
   * Create a new movement in DB linked to an account.
   *
   * @param movementRecord with the information from the movement to be created.
   */
  void createMovement(MovementRecord movementRecord);

  /**
   * Get all movements from a client account, by defining a date range.
   *
   * @param accountNumber number from the account to get the movements.
   * @param start the start date in format String start, String end.
   * @param end the end date in format String start, String end.
   * @return A list of movements from the client account into the given range.
   */
  List<MovementRecord> getMovements(String accountNumber, LocalDate start, LocalDate end);
}
