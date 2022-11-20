package com.diy.software;

import com.diy.hardware.DoItYourselfStationAR;
import com.diy.simulation.Customer;

public class MembershipScreenGui extends javax.swing.JFrame {

    private static DoItYourselfStationLogic stationLogic;
    private static Customer customer;
    private static DoItYourselfStationAR station;

    public MembershipScreenGui(Customer customer, DoItYourselfStationAR station, DoItYourselfStationLogic stationLogic) {
        //initComponents();
        MembershipScreenGui.customer = customer;
        MembershipScreenGui.station = station;
        MembershipScreenGui.stationLogic = stationLogic;

    }
}
//sourced from netbeans
