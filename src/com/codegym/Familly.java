package com.codegym;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Familly implements Serializable {
    private int famillyMembers;
    private int address;
    private List<Person> members = new ArrayList<>();


    public Familly(int famillyMembers, int address, List<Person> members) {
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

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public void displayAllMember() {
        for (Person member: members) {
            System.out.println(member);
        }
    }
    @Override
    public String toString() {
        return "số thành viên: "+this.famillyMembers + ", số nhà: " + this.address + "\nCác thành viên trong gia đình:" ;
    }
}
