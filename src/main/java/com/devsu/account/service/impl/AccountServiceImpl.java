package com.devsu.account.service.impl;

import com.devsu.account.entity.dto.AccountDto;
import com.devsu.account.entity.dto.AccountRecord;
import com.devsu.account.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public void createAccount(AccountRecord accountRecord) {

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
    public void updateAccount(AccountRecord accountRecord) {

    }

}
