/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.controller;

import com.mycompany.vendingmachine.Dao.NoItemInInventoryException;
import com.mycompany.vendingmachine.Dao.VendingMachineDao;
import com.mycompany.vendingmachine.Dto.Change;
import com.mycompany.vendingmachine.Dto.Product;
import com.mycompany.vendingmachine.Dto.User;
import com.mycompany.vendingmachine.service.InsufficientFundsException;
import com.mycompany.vendingmachine.service.VendingMachineService;
import com.mycompany.vendingmachine.view.VendingMachineView;
import java.math.BigDecimal;

/**
 *
 * @author OliverTLee
 */
public class Controller {

    VendingMachineView view;
    VendingMachineService service;
    User user = new User();

    public Controller(VendingMachineView view, VendingMachineService service) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        // This is the main body of the controller program.
        boolean keepShopping = true;
        while (keepShopping) {
            view.displayVendingMachine(service.getAllProducts());
            String choice = view.askItemChoice();
            if (choice.toLowerCase().contains("q")) {
                keepShopping = false;
                break;
            } try  {
                service.checkStock(choice);
                BigDecimal userCash = view.askMoney();
                try  {
                    service.checkCanAfford(userCash, choice);
                    Product product = service.decreaseStock(choice);
                    view.giveItem(product);
                    user.addItem(product);
                    Change change = service.calculateChange(userCash, choice);
                    view.displayChange(change);
                } catch (InsufficientFundsException e) {
                    view.displayNotEnoughMoney();
                    view.returnMoney(userCash);
                }
            } // if item is out of stock...
            catch(NoItemInInventoryException e) {
                view.displayCannotPurchase(choice);
            }
            keepShopping = view.askContinue();
        }
        service.exit();
        view.displayUserItems(user);
        view.displayExit();
    }
}
