/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.Dao.NoItemInInventoryException;
import com.mycompany.vendingmachine.Dao.VendingMachineDao;
import com.mycompany.vendingmachine.Dao.VendingMachineStubDao;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author OliverTLee
 */
public class VendingMachineServiceImplTest {

    VendingMachineDao dao = new VendingMachineStubDao();
    VendingMachineService service = new VendingMachineServiceImpl(dao);

    public VendingMachineServiceImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testNoInventory() {
        try {
            String choice = "A2";
            boolean stockAboveZero = service.checkStock(choice); // should throw an error because inventory is 0.
            assertFalse(stockAboveZero);
        } catch (NoItemInInventoryException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testNotEnoughCash() {
        try {
            String choice = "A3";
            BigDecimal cash = BigDecimal.ONE;
            boolean stockAboveZero = service.checkStock(choice);
            service.checkCanAfford(cash, choice);
        } catch (InsufficientFundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testBuyItemSuccessfully() {
        String choice = "A1";
        BigDecimal cash = BigDecimal.ONE;
        boolean stockAboveZero = service.checkStock(choice);
        service.checkCanAfford(cash, choice);
        assertTrue(true);
    }
}
