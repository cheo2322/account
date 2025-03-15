package com.devsu.account.mapper;

import com.devsu.account.entity.Account;
import com.devsu.account.entity.dto.AccountRecord;

public class AccountMapper {

  public static Account recordToAccount(AccountRecord accountRecord) {
    Account account = new Account();
    account.setClientIdentification(accountRecord.clientIdentification());
    account.setType(Account.AccountType.valueOf(accountRecord.type().toUpperCase()));
    account.setStatus(accountRecord.status());
    account.setInitialBalance(accountRecord.initialBalance());

    return account;
  }
}
