/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.view;

import com.mycompany.vendingmachine.Dto.Change;
import com.mycompany.vendingmachine.Dto.Product;
import com.mycompany.vendingmachine.Dto.User;
import com.mycompany.vendingmachine.UI.UserIO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OliverTLee
 */
public class VendingMachineViewImpl implements VendingMachineView {

    UserIO io;

    public VendingMachineViewImpl(UserIO io) {
        this.io = io;
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void displayChange(Change change) {
        System.out.println("Your change is: ");
        if (change.getNumberOfQuarters() > 0) {
            System.out.print(change.getNumberOfQuarters() + " Quarter(s), ");
        }
        if (change.getNumberOfDimes() > 0) {
            System.out.print(change.getNumberOfDimes() + " Dime(s), ");
        }
        if (change.getNumberOfNickels() > 0) {
            System.out.print(change.getNumberOfNickels() + " Nickel(s), ");
        }
        if (change.getNumberOfPennies() > 0) {
            System.out.print(change.getNumberOfPennies() + " Penny(ies), ");
        }
        System.out.println("");
    }

    @Override
    public void displayNotEnoughMoney() {
        System.out.println("Sorry, you can't afford that item.");
    }

    @Override
    public void pause() {
        System.out.println("Please hit Enter to continue");
        SCANNER.next();
        return;
    }

    @Override
    public BigDecimal askMoney() {
        System.out.println("How much money would you like to enter to the machine?");
        String moneyString = SCANNER.next();
        return new BigDecimal(moneyString);
    }

    @Override
    public String askItemChoice() {
        System.out.println("What item would you like to buy?)");
        System.out.println("Or QUIT to quit");
        String choice = SCANNER.next();
        return choice;
    }

    @Override
    public void displayVendingMachine(ArrayList<Product> products) {
        int pointer = 0;
        String border = "_____________________________________________________________";
        System.out.println(border);
        while (pointer <= products.size()-4) {
            printRow(products,pointer);
            System.out.println("");
            pointer += 4;
        }
        System.out.println(border);
    }

    @Override
    public void giveItem(Product product) {
        System.out.println(product.getName() + " has been dispensed.");
    }

    @Override
    public void displayCannotPurchase(String location) { // A1 A2 A3 
        if (location.charAt(1) > '4') {
            System.out.println("Error, user entry out of range");
        } else {
            System.out.println("Sorry, that item is out of stock.");
        }
    }

    @Override
    public boolean askContinue() {
        String yesOrNo = io.readString("Would you like to purchase more items? (y/n)");
        if (yesOrNo.contains("y")) {
            return true;
        }
        return false;
    }

    @Override
    public void displayExit() {
        System.out.println("thank you for your business.");
    }

    private void printRow(ArrayList<Product> products, int start) {
        System.out.print("|  ");
        for (int i = start; i < (start + 4); i++) {
            System.out.print(padRight(products.get(i).getLocation(), 15));
        }
        System.out.print(padRight("|", 3));
        System.out.println("");
        System.out.print("|  ");
        for (int i = start; i < (start + 4); i++) {
            if (products.get(i).getNumberInStock() > 0) {
                System.out.print(padRight(products.get(i).getName(), 15));
            } else {
                System.out.print(padRight("empty", 15));
            }
        }
        System.out.print(padRight("|", 3));
        System.out.println("");
        System.out.print("|  ");
        for (int i = start; i < (start + 4); i++) {
            System.out.print(padRight(products.get(i).getPrice().toString(), 15));
        }
        System.out.print(padRight("|", 3));
        System.out.println("");
        System.out.print("|  ");
    }

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    @Override
    public void displayUserItems(User user) {
        ArrayList<Product> products = user.getUserItems();
        System.out.print("You have purchased ");
        if (products.size() ==0) {
            System.out.print("nothing. ");
        }
        for (Product prod : products) {
            System.out.print(prod.getName() + ", ");
        }
    }

    @Override
    public void returnMoney(BigDecimal userCash) {
        Change change = new Change(userCash, BigDecimal.ZERO);
        System.out.println("Your money has been refunded.");
        displayChange(change);
        return;
    }
}
