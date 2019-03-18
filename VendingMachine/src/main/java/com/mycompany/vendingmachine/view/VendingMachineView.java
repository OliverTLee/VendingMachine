/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.view;

import com.mycompany.vendingmachine.Dto.Change;
import com.mycompany.vendingmachine.Dto.Product;
import com.mycompany.vendingmachine.Dto.User;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author OliverTLee
 */
public interface VendingMachineView {
    
    public void displayVendingMachine(ArrayList<Product> products) ; 
    public void displayChange(Change change) ;
    public void displayNotEnoughMoney() ;
    public void displayCannotPurchase(String location);
    public void pause() ;
    public BigDecimal askMoney() ;
    public String askItemChoice() ;
    public void giveItem(Product prod);
    public boolean askContinue();
    public void displayUserItems(User user);
    public void displayExit();

    public void returnMoney(BigDecimal userCash);
    
}
