package com.bank.transactionservice.service;

import com.bank.transactionservice.entity.Account;
import com.bank.transactionservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) {
        Account from = accountRepository.findById(fromAccountId).orElseThrow(
                () -> new RuntimeException("Sender Account not found")
        );

        Account to = accountRepository.findById(toAccountId).orElseThrow(
                () -> new RuntimeException("Receiver Account not found")
        );

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.save(from);
        accountRepository.save(to);
    }
}
