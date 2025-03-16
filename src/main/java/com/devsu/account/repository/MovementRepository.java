package com.devsu.account.repository;

import com.devsu.account.entity.Movement;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {

  Optional<Movement> findTopByOrderByMovementDateDesc();
}
