package com.devsu.account.entity.dto;

public record AccountRecord(
    String clientIdentification, String type, Long initialBalance, Boolean status) {}
