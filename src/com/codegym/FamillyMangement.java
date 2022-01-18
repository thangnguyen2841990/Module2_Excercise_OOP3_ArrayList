package com.codegym;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FamillyMangement {
    private ArrayList<Familly> famillies;

    public FamillyMangement() {
        this.famillies = new ArrayList<>();
    }

    public FamillyMangement(ArrayList<Familly> famillies) {
        this.famillies = famillies;
    }

    public ArrayList<Familly> getFamillies() {
        return famillies;
    }

    public void setFamillies(ArrayList<Familly> famillies) {
        this.famillies = famillies;
    }

    public void addNewFamilly(Familly newFamilly) {
        famillies.add(newFamilly);
    }

    public void displayAllFamillies() {
        for (int i = 0; i < famillies.size(); i++) {
            System.out.println((i + 1) + ". " + famillies.get(i));
            famillies.get(i).displayAllMember();
        }
    }
    public Date convertToDate(String birthDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public void displayOver80YearsOld(){
        for (int i = 0; i < famillies.size(); i++) {
            for (int j = 0; j < famillies.get(i).getMembers().length; j++) {
                if (convertToDate(famillies.get(i).getMembers()[j].getBirthDay()).getYear() <= 42){
                    System.out.println(famillies.get(i));
                    famillies.get(i).displayAllMember();
                }
            }
        }
    }

    public void removeFamilly(int index) {
        famillies.remove(index);
    }

    public void updateFamilly(int index, Familly newFamilly) {
        famillies.set(index, newFamilly);
    }


}
