package com.codegym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Familly {
    private int famillyMembers;
    private int address;
    private Person[] members = new Person[famillyMembers];


    public Familly() {

    }

    public Familly(int famillyMembers, int address, Person[] members) {
        this.famillyMembers = famillyMembers;
        this.address = address;
        this.members = members;
    }

    public int getFamillyMembers() {
        return famillyMembers;
    }

    public void setFamillyMembers(int famillyMembers) {
        this.famillyMembers = famillyMembers;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public Person[] getMembers() {
        return members;
    }

    public void setMembers(Person[] members) {
        this.members = members;
    }

    public void displayAllMember() {
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i]);
        }
    }



//    public void findOver80YearsOld() {
//        for (int i = 0; i < members.length; i++) {
//            if (convertToDate(members[i].getBirthDay()).getYear() <= 42) {
//                System.out.println(members[i]);
//            }
//        }
//    }


    @Override
    public String toString() {
        return "Tổng số thành viên trong nhà: " + this.famillyMembers + ", số nhà: " + this.address + "\nCác thành viên trong gia đình: ";
    }
}
