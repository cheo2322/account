package com.devsu.account.entity.dto;

import java.time.LocalDate;

public record MovementRecord(
    LocalDate date, String type, Double value, Double balance, String accountNumber) {}
