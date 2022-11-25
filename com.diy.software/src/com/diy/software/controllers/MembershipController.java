package com.diy.software.controllers;

import java.util.HashMap;
import java.util.Map;


public class MembershipController {
    private class MembershipInfo {
        String name;
        String memberID;
        int year_opened;
        String month_opened;
        int day_opened;
        int status = 1;

        public MembershipInfo(String name, int year_opened, String month_opened, int day_opened, String membershipID) {
            this.name = name;
            this.year_opened = year_opened;
            this.month_opened = month_opened;
            this.day_opened = day_opened;
            this.memberID = membershipID;
        }

        public MembershipInfo(String name, int year_opened, String month_opened, int day_opened, int status, String membershipID) {
            this.name = name;
            this.year_opened = year_opened;
            this.month_opened = month_opened;
            this.day_opened = day_opened;
            this.status = status;
            this.memberID = membershipID;
        }
    }

    private static HashMap<String, MembershipInfo> membershipDatabase = new HashMap<>();
    public static MembershipInfo activeMember = null;

    public void insertMember(String membershipID, String name, int year_opened, String month_opened, int day_opened, int status){
        MembershipInfo newMember = new MembershipInfo(name, year_opened, month_opened, day_opened, status, membershipID);
        membershipDatabase.put(membershipID, newMember);
    }

    public void insertMember(String membershipID, String name, int year_opened, String month_opened, int day_opened){
        if(membershipID != null) {
            MembershipInfo newMember = new MembershipInfo(name, year_opened, month_opened, day_opened, membershipID);
            membershipDatabase.put(membershipID, newMember);
        }
    }

    public boolean verifyMembership(String input){
        if(input != null) {
            if (membershipDatabase.containsKey(input)) {
                System.out.println(membershipDatabase.get(input).name);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * 
     * 
     * @param input the ID as input
     */
    public static String getName(String input){return membershipDatabase.get(input).name;}
    public static String getMonth(String input){return membershipDatabase.get(input).month_opened;}
    public static int getDay(String input){return membershipDatabase.get(input).day_opened;}
    public static int getYear(String input){return membershipDatabase.get(input).year_opened;}

    //Set active member
    public void setActiveMember(String input){
        if(input != null) {
            if (verifyMembership(input)) {
                activeMember = membershipDatabase.get(input);
            }
        }
    }

    // Get active member
    public boolean hasActiveMember(){
        return activeMember != null && verifyMembership(activeMember.memberID);
    }
    public String getActiveMemberName(){return activeMember.name;}
    public String getActiveMemberMonth(){return activeMember.month_opened;}
    public int getActiveMemberDay(){return activeMember.day_opened;}
    public int getActivateMemberYear(){return activeMember.year_opened;}
    public String getActivateMemberID(){return activeMember.memberID;}

    // Unset active member
    public void unsetActiveMember(){
        activeMember = null;
    }

}

