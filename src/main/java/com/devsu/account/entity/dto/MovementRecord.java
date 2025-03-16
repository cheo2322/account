package com.devsu.account.entity.dto;

import java.time.LocalDateTime;

public record MovementRecord(
    LocalDateTime date, String type, Double value, Double balance, String accountNumber) {}
