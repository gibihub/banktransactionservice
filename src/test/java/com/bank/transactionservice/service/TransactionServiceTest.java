package com.bank.transactionservice.service;

import com.bank.transactionservice.entity.Account;
import com.bank.transactionservice.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransactionServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    @Transactional
    void testTransferMoney() {
        Account sender = new Account();
        Account receiver = new Account();
        sender.setBalance(800.0);
        receiver.setBalance(500.0);

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        // ✅ Performing the transaction
        transactionService.transferMoney(1L, 2L, 200.0);

        // ✅ Check if balances are updated
        assertEquals(800.0, sender.getBalance());  // 🔥 Ensure `getBalance()` exists
        assertEquals(700.0, receiver.getBalance());
    }
}