package com.diy.software.controllers;

import java.util.HashMap;
import java.util.Map;


public class MembershipController {
    private class MembershipInfo {
        String name;
        int year_opened;
        String month_opened;
        int day_opened;
        int status = 1;

        public MembershipInfo(String name, int year_opened, String month_opened, int day_opened) {
            this.name = name;
            this.year_opened = year_opened;
            this.month_opened = month_opened;
            this.day_opened = day_opened;
        }

        public MembershipInfo(String name, int year_opened, String month_opened, int day_opened, int status) {
            this.name = name;
            this.year_opened = year_opened;
            this.month_opened = month_opened;
            this.day_opened = day_opened;
            this.status = status;
        }
    }

    private static HashMap<String, MembershipInfo> membershipDatabase = new HashMap<>();

    public void insertMember(String membershipID, String name, int year_opened, String month_opened, int day_opened, int status){
        MembershipInfo newMember = new MembershipInfo(name, year_opened, month_opened, day_opened, status);
        membershipDatabase.put(membershipID, newMember);
    }

    public void insertMember(String membershipID, String name, int year_opened, String month_opened, int day_opened){
        
    	MembershipInfo newMember = new MembershipInfo(name, year_opened, month_opened, day_opened);
        membershipDatabase.put(membershipID, newMember);
    }

    public int verifyMembership(String input){
        if(membershipDatabase.containsKey(input)){
            System.out.println(membershipDatabase.get(input).name);
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * 
     * 
     * @param input the ID as input
     */
    public static String getName(String input){
        return membershipDatabase.get(input).name;
    }

}

