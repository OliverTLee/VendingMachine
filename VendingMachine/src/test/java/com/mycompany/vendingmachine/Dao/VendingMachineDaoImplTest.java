/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dao;

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
public class VendingMachineDaoImplTest {

    VendingMachineDao dao = new VendingMachineDaoImpl("stocktest.txt");

    public VendingMachineDaoImplTest() {

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
    public void testDecreaseStock() {
        boolean initial = dao.checkStock("A1");
        dao.decreaseStock("A1");
        assertTrue(initial);
        try {
            boolean post = dao.checkStock("A1");
        } catch (NoItemInInventoryException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetPrice() {
        BigDecimal priceGoal = new BigDecimal("1.50");
        BigDecimal priceActual = dao.getPrice("A2");
        assertEquals(priceGoal, priceActual);
    }

    @Test
    public void testGetAll() {
        int expectedSize = 4;
        int actualSize = dao.getAllProducts().size();
        assertEquals(expectedSize, actualSize);
    }

}
