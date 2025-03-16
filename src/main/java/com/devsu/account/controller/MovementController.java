package com.devsu.account.controller;

import com.devsu.account.entity.dto.MovementRecord;
import com.devsu.account.service.MovementService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/v1/movimientos")
public class MovementController {

  private final MovementService movementService;

  public MovementController(MovementService movementService) {
    this.movementService = movementService;
  }

  @PostMapping
  public ResponseEntity<Void> createMovement(@RequestBody MovementRecord movementRecord) {
    movementService.createMovement(movementRecord);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  public ResponseEntity<List<MovementRecord>> getMovements(
      @RequestParam("clientId") String clientIdentification,
      @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
      @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

    return ResponseEntity.ok(movementService.getMovements(clientIdentification, start, end));
  }
}
