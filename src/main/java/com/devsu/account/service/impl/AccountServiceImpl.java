package com.devsu.account.service.impl;

import com.devsu.account.entity.Account;
import com.devsu.account.entity.dto.AccountDto;
import com.devsu.account.entity.dto.AccountRecord;
import com.devsu.account.mapper.AccountMapper;
import com.devsu.account.repository.AccountRepository;
import com.devsu.account.service.AccountService;
import com.devsu.account.web.ClientService;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;
  private final ClientService clientService;

  public AccountServiceImpl(AccountRepository accountRepository, ClientService clientService) {
    this.accountRepository = accountRepository;
    this.clientService = clientService;
  }

  @Override
  public void createAccount(AccountRecord accountRecord) {
    Mono<Void> clientResponse =
        clientService.checkClientExistence(accountRecord.clientIdentification());

    Account account = AccountMapper.recordToAccount(accountRecord);
    account.setNumber(this.generateAccountNumber());

    clientResponse.subscribe(
        unused -> System.out.println("Good!"),
        throwable -> System.out.println(throwable.getMessage()));

    clientResponse.block(); // TODO: make the whole application reactive

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
