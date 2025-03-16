package com.devsu.account.mapper;

import com.devsu.account.entity.Movement;
import com.devsu.account.entity.dto.MovementRecord;

public class MovementMapper {

  public static Movement recordToMovement(MovementRecord movementRecord) {
    Movement movement = new Movement();
    movement.setValue(movementRecord.value());

    return movement;
  }

  public static MovementRecord movementToRecord(Movement movement) {
    return new MovementRecord(
        movement.getDate().toLocalDate(),
        movement.getType().toString(),
        movement.getValue(),
        movement.getBalance(),
        movement.getAccount().getNumber());
  }
}
