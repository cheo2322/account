package com.devsu.account.entity.dto;

public record AccountRecord(
    String number,
    String clientIdentification,
    String type,
    Double initialBalance,
    Boolean status) {}
