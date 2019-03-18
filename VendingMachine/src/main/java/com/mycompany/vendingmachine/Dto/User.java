/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Dto;

import java.util.ArrayList;

/**
 *
 * @author OliverTLee
 */
public class User {

    ArrayList<Product> purchasedList;

    public User() {
        purchasedList = new ArrayList<>();
    }

    public ArrayList<Product> getUserItems() {
        return purchasedList;
    }
    public void addItem(Product prod) {
        purchasedList.add(prod);
    }
    
}
