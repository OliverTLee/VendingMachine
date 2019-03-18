/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dao;

import com.mycompany.vendingmachine.Dto.Product;
import com.mycompany.vendingmachine.Dto.Change;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OliverTLee
 */
public interface VendingMachineDao {
    
   
    public void writeStockFile() ; 
    public void readStockFile() ;
    public Product decreaseStock(String productLoc);
    public ArrayList<Product> getAllProducts();
    public boolean checkStock(String productLoc);
    public void exit();
    public BigDecimal getPrice(String location);
    
}
