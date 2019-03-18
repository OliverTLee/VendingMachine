/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dao;

import com.mycompany.vendingmachine.Dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author OliverTLee
 */
public class VendingMachineStubDao implements VendingMachineDao {

    private ArrayList<Product> products = new ArrayList<>();

    public VendingMachineStubDao() {
        Product product1 = new Product("Test", BigDecimal.ONE, 1, "A1");
        products.add(product1);
        Product product2 = new Product("Test2", BigDecimal.ONE, 0, "A2");
        products.add(product2);
        Product product3 = new Product("Test3", BigDecimal.TEN, 1, "A3");
        products.add(product3);
    }

    @Override
    public void writeStockFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readStockFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product decreaseStock(String productLoc) {
        for (Product prod : products) {
            if (prod.getLocation().equals(productLoc)) {
                prod.setNumberInStock(prod.getNumberInStock() - 1);
                return prod;
            }
        }
        throw new NoItemInInventoryException("That item is not in stock.");
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkStock(String productLoc) {
        //return true if an item has stock greater than 0,
        //throw error if item not in inventory or not found.
        for (Product prod : products) {
            if (prod.getLocation().equals(productLoc)) {
                if (prod.getNumberInStock() > 0) {
                    return true;
                }
            }
        }
        throw new NoItemInInventoryException("Item not in stock");
    }

    @Override
    public void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal getPrice(String productLoc) {
        for (Product prod : products) {
            if (prod.getLocation().equals(productLoc)) {
                return prod.getPrice();
            }
        }
        return BigDecimal.ZERO;
    }

}
