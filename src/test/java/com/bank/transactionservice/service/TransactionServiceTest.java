package com.bank.transactionservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@TestComponent
class TransactionServiceTest {
    private TransactionService transactionService;

    @Test
    void testTransferMoney() {
        transactionService.transferMoney(1L, 2L, 500.0);
        assertNotNull(transactionService);
    }
}