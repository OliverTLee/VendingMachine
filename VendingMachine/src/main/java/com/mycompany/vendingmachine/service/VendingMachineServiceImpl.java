/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.Dao.VendingMachineDao;
import com.mycompany.vendingmachine.Dto.Change;
import com.mycompany.vendingmachine.Dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author OliverTLee
 */
public class VendingMachineServiceImpl implements VendingMachineService{
    
    VendingMachineDao dao ; 
    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    @Override
    public boolean checkStock(String choice) {
        return dao.checkStock(choice);
    }

    @Override
    public boolean checkCanAfford(BigDecimal userCash, String choice) {
        BigDecimal productPrice = dao.getPrice(choice);
        if (productPrice.compareTo(userCash) > 0) {
            throw new InsufficientFundsException("You cannot afford this item");
        }
        return true;
    }

    @Override
    public Product decreaseStock(String choice) {
        return dao.decreaseStock(choice);
    }

    @Override
    public Change calculateChange(BigDecimal userCash, String choice) {
        ArrayList<Product> products = dao.getAllProducts();
        for (Product prod : products) {
            if (prod.getLocation().equals(choice)) {
                return new Change(userCash,prod.getPrice());
            }
        }
        return new Change(userCash,BigDecimal.ZERO);
    }

    @Override
    public void exit() {
        dao.exit();
    }
    
    
    
}
