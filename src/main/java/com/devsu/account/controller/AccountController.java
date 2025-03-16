package com.devsu.account.controller;

import com.devsu.account.entity.dto.AccountRecord;
import com.devsu.account.service.AccountService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/v1/cuentas")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  public ResponseEntity<Void> createAccount(@RequestBody AccountRecord accountRecord) {
    accountService.createAccount(accountRecord);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  public ResponseEntity<List<AccountRecord>> getAllAccounts() {
    return ResponseEntity.ok(accountService.getAccounts());
  }

  @GetMapping("/{accountNumber}")
  public ResponseEntity<AccountRecord> getAccount(@PathVariable String accountNumber) {
    return ResponseEntity.ok(accountService.getAccount(accountNumber));
  }

  @PatchMapping
  public ResponseEntity<Void> updateAccount(@RequestBody AccountRecord accountRecord) {
    accountService.updateAccount(accountRecord);

    return ResponseEntity.ok().build();
  }
}
