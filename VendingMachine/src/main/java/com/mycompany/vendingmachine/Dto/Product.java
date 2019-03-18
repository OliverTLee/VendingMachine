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
public class Product {
    String name;
    BigDecimal price ;
    int numberInStock ;
    String location ; 
    
    public Product(String name, BigDecimal price, int numberInStock, String location) {
        this.price = price;
        this.name = name;
        this.numberInStock = numberInStock;
        this.location = location ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public int getNumberInStock() {
        return numberInStock ;
    }
    public void setNumberInStock(int num) {
        this.numberInStock = num;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
