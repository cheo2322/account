package com.devsu.account.service.impl;

import com.devsu.account.entity.dto.MovementRecord;
import com.devsu.account.service.MovementService;
import java.time.LocalDate;
import java.util.List;

public class MovementServiceImpl implements MovementService {

  @Override
  public void createMovement(MovementRecord movementRecord) {}

  @Override
  public List<MovementRecord> getMovements(
      String clientIdentification, LocalDate start, LocalDate end) {
    return List.of();
  }
}
