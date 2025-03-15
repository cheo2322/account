package com.devsu.account.service.impl;

import com.devsu.account.entity.Account;
import com.devsu.account.entity.dto.AccountDto;
import com.devsu.account.entity.dto.AccountRecord;
import com.devsu.account.mapper.AccountMapper;
import com.devsu.account.repository.AccountRepository;
import com.devsu.account.service.AccountService;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void createAccount(AccountRecord accountRecord) {
    Account account = AccountMapper.recordToAccount(accountRecord);
    account.setNumber(this.generateAccountNumber());

    accountRepository.save(account);
  }

  @Override
  public List<AccountDto> getAccounts() {
    return List.of();
  }

  @Override
  public AccountDto getAccount(String accountNumber) {
    return null;
  }

  @Override
  public void updateAccount(AccountRecord accountRecord) {}

  /**
   * Generate a random account number for new accounts.
   *
   * @return the new number account.
   */
  private String generateAccountNumber() {
    StringBuilder accountNumberBuilder = new StringBuilder();

    Random random = new Random();
    Optional<Account> accountByNumber;
    String possibleAccountNumber;

    do {
      int randomNumber = 10000000 + random.nextInt(90000000);
      possibleAccountNumber = "00".concat(String.valueOf(randomNumber));

      accountByNumber = accountRepository.findByNumber(possibleAccountNumber);
    } while (accountByNumber.isPresent());

    return possibleAccountNumber;
  }
}
