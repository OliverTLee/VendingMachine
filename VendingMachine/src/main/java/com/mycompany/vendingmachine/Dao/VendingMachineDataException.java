/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dao;

/**
 *
 * @author OliverTLee
 */
public class VendingMachineDataException extends RuntimeException{
    public VendingMachineDataException(String message) {
        super(message);
    }
    public VendingMachineDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
