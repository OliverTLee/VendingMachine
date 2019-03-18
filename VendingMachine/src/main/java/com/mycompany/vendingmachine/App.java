/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine;

import com.mycompany.vendingmachine.Dao.VendingMachineDao;
import com.mycompany.vendingmachine.Dao.VendingMachineDaoImpl;
import com.mycompany.vendingmachine.UI.UserIO;
import com.mycompany.vendingmachine.UI.UserIOConsoleImpl;
import com.mycompany.vendingmachine.controller.Controller;
import com.mycompany.vendingmachine.service.VendingMachineService;
import com.mycompany.vendingmachine.service.VendingMachineServiceImpl;
import com.mycompany.vendingmachine.view.VendingMachineView;
import com.mycompany.vendingmachine.view.VendingMachineViewImpl;

/**
 *
 * @author OliverTLee
 */
public class App {

    static final String STOCKFILE = "stockfile.txt";

    public static void main(String[] args) {

        UserIO io = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineViewImpl(io);
        VendingMachineDao dao = new VendingMachineDaoImpl(STOCKFILE);
        VendingMachineService service = new VendingMachineServiceImpl(dao);
        Controller controller = new Controller(view, service);

        controller.run();
    }

}
