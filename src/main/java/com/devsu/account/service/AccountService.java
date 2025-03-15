package com.devsu.account.service;

import com.devsu.account.entity.dto.AccountDto;
import com.devsu.account.entity.dto.AccountRecord;
import java.util.List;

/** Service for clients' accounts. */
public interface AccountService {

  /**
   * Create a new account in DB linked to a Client.
   *
   * @param accountRecord with the information from the Account to be created.
   */
  void createAccount(AccountRecord accountRecord);

  /**
   * Retrieve all accounts from DB.
   *
   * @return A List of all accounts.
   */
  List<AccountDto> getAccounts();

  /**
   * Retrieve an account related to a client by using the identification;
   *
   * @param accountNumber the number of account to be retrieved;
   * @return the account related to the client.
   */
  AccountDto getAccount(String accountNumber);

  /**
   * Update details from an account.
   *
   * @param accountRecord with the information from the Account to be updated.
   */
  void updateAccount(AccountRecord accountRecord);
}
