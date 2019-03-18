/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dao;

import com.mycompany.vendingmachine.Dto.Product;
import com.mycompany.vendingmachine.Dto.Change;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OliverTLee
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    public ArrayList<Product> products = new ArrayList<>();
    String STOCKFILE = "stockfile.txt";
    static final String DELIMITER = "::";

    public VendingMachineDaoImpl(String stockFile) {
        this.STOCKFILE = stockFile;
        readStockFile();
        while (products.size() %4 != 0 ){
            products.add(new Product("empty",BigDecimal.ZERO,0,"--"));
        }
    }
    
    @Override
    public void readStockFile() {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(STOCKFILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDataException("Failed to stock machine :'(");
        }
        String currentLine;
        String[] tokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            tokens = currentLine.split(DELIMITER);
            Product prod = new Product(tokens[0],
                    new BigDecimal(tokens[1]),
                    Integer.parseInt(tokens[2]),
                    tokens[3]);
            products.add(prod);
        }
        scanner.close();
    }

    @Override
    public void writeStockFile() {
        PrintWriter write;
        try {
            write = new PrintWriter(new FileWriter(STOCKFILE, false));
        } catch (IOException e) {
            throw new VendingMachineDataException("Vending Machine failed to store it's items :(");
        }
        for (Product prod : products) {
            write.println(prod.getName() + DELIMITER
                    + prod.getPrice() + DELIMITER
                    + prod.getNumberInStock() + DELIMITER
                    + prod.getLocation() + DELIMITER
            );
            write.flush();
        }
        write.close();
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
        return products;
    }

    @Override
    public boolean checkStock(String productLoc) {
        //return true if an item has stock greater than 0,
        //return false if no item, or item doesn't exist
        for (Product prod : products) {
            if (prod.getLocation().equals(productLoc)) {
                if (prod.getNumberInStock() > 0) {
                    return true;
                }
            }
        }
        throw new NoItemInInventoryException("Item not in stock");
    }

    public BigDecimal getPrice(String productLoc) {
        for (Product prod : products) {
            if(prod.getLocation().equals(productLoc)) {
                return prod.getPrice();
            }
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void exit() {
        writeStockFile();
    }
    
    
}
