package com.diy.software;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

import javax.swing.*;

public class DebitCardInputGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;

    public DebitCardInputGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        //initComponents();
        DebitCardInputGui.customer = customer;
        DebitCardInputGui.station = station;
        DebitCardInputGui.stationLogic = stationLogic;

    }

}
//sourced from netbeans
