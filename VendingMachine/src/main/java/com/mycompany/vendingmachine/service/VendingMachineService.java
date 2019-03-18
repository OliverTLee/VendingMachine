/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.service;

import com.mycompany.vendingmachine.Dto.Change;
import com.mycompany.vendingmachine.Dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author OliverTLee
 */
public interface VendingMachineService {

    public ArrayList<Product> getAllProducts();
    //Service layer as a DAO that it can access.

    public boolean checkStock(String choice);

    public boolean checkCanAfford(BigDecimal userCash, String choice);

    public Product decreaseStock(String choice);

    public Change calculateChange(BigDecimal userCash, String choice);

    public void exit();

}
