/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dto;

import java.math.BigDecimal;

/**
 *
 * @author OliverTLee
 */
public class Change {
    
    // change can be Quarter, Dime, Nickel, and Penny. 
    // Stored as an int array, of [0] = Quarter, [1] = Dime, [2] = Nickel, [3] = Penny.
    
    private final BigDecimal quarter = new BigDecimal(".25");
    private final BigDecimal dime = new BigDecimal(".10");
    private final BigDecimal nickel = new BigDecimal(".05");
    private final BigDecimal penny = new BigDecimal(".01");
    private int numberOfQuarters ;
    private int numberOfDimes ;
    private int numberOfNickels ;
    private int numberOfPennies ;
    
    public Change(BigDecimal provided, BigDecimal cost) {
        numberOfQuarters = 0;
        numberOfDimes = 0;
        numberOfNickels = 0;
        numberOfPennies = 0;
        BigDecimal changeAmount = provided.subtract(cost);
        while (changeAmount.compareTo(quarter)>=0) {
            changeAmount = changeAmount.subtract(quarter);
            numberOfQuarters ++;
        } while (changeAmount.compareTo(dime)>=0) {
            changeAmount = changeAmount.subtract(dime);
            numberOfDimes ++;
        } while (changeAmount.compareTo(nickel)>=0) {
            changeAmount = changeAmount.subtract(nickel);
            numberOfNickels ++;
        } while (changeAmount.compareTo(penny)>=0) {
            changeAmount = changeAmount.subtract(penny);
            numberOfPennies ++;
        } 
        
    }

    public int getNumberOfQuarters() {
        return numberOfQuarters;
    }

    public void setNumberOfQuarters(int numberOfQuarters) {
        this.numberOfQuarters = numberOfQuarters;
    }

    public int getNumberOfDimes() {
        return numberOfDimes;
    }

    public void setNumberOfDimes(int numberOfDimes) {
        this.numberOfDimes = numberOfDimes;
    }

    public int getNumberOfNickels() {
        return numberOfNickels;
    }

    public void setNumberOfNickels(int numberOfNickels) {
        this.numberOfNickels = numberOfNickels;
    }

    public int getNumberOfPennies() {
        return numberOfPennies;
    }

    public void setNumberOfPennies(int numberOfPennies) {
        this.numberOfPennies = numberOfPennies;
    }
}
