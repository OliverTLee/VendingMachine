/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dto;

import java.math.BigDecimal;
import java.math.BigInteger;
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
public class ChangeTest {
    
    BigDecimal cost = new BigDecimal("1.00");
    BigDecimal userMoney = new BigDecimal("2.00");
    Change change = new Change(userMoney, cost);
    
    public ChangeTest() {
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

    /**
     * Test of getNumberOfQuarters method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfQuarters() {
        assertEquals(4,change.getNumberOfQuarters());
    }

    /**
     * Test of setNumberOfQuarters method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testSetNumberOfQuarters() {
    }

    /**
     * Test of getNumberOfDimes method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfDimes() {
        
    }

    /**
     * Test of setNumberOfDimes method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testSetNumberOfDimes() {
    }

    /**
     * Test of getNumberOfNickels method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfNickels() {
    }

    /**
     * Test of setNumberOfNickels method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testSetNumberOfNickels() {
    }

    /**
     * Test of getNumberOfPennies method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfPennies() {
    }

    /**
     * Test of setNumberOfPennies method, of class Change.
     */
    @org.junit.jupiter.api.Test
    public void testSetNumberOfPennies() {
    }
    
}
