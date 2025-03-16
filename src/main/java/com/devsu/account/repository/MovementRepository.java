package com.devsu.account.repository;

import com.devsu.account.entity.Movement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {

  Optional<Movement> findTopByOrderByMovementDateDesc();

  List<Movement> findByAccountNumberAndDateBetween(
      String accountNumber, LocalDateTime startDate, LocalDateTime endDate);
}
