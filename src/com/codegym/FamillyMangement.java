package com.codegym;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FamillyMangement {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Familly> famillies;
    private ArrayList<Person> members;
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
            System.out.println("Hộ dân số: "+(i + 1) + ". " + famillies.get(i));
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

    public void displayOver80YearsOld() {
        for (int i = 0; i < famillies.size(); i++) {
            for (int j = 0; j < famillies.get(i).getMembers().size(); j++) {
                if (convertToDate(famillies.get(i).getMembers().get(j).getBirthDay()).getYear() <= 42) {
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
    public void writeToFile(List<Familly> famillies) throws IOException {
        OutputStream os = new FileOutputStream("familly2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(famillies);
    }
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.famillies = (ArrayList<Familly>) ois.readObject();
    }
    public  void menu() {
        System.out.println("----MENU QUẢN LÝ CÁC HỘ DÂN----");
        System.out.println("1. Hiển thị thông tin các hộ dân.");
        System.out.println("2. Thêm hộ dân");
        System.out.println("3. Xóa hộ dân");
        System.out.println("4. Cập nhật hộ dân");
        System.out.println("5. Hộ dân có người mừng thọ 80 tuổi");
        System.out.println("0. Thoát");
    }

    public  Familly inputFamillyInfo() {
        String name = "";
        String birthDay = "";
        String job = "";
        System.out.println("Nhập thông tin của hộ dân: ");
        System.out.println("Sô thành viên trong nhà: ");
        int famillyMembers = scanner.nextInt();
        System.out.println("Nhập số nhà: ");
        int address = scanner.nextInt();
        System.out.println("Nhập từng thành viên trong gia đình");
        List<Person> members = new ArrayList<>();
        for (int i = 0; i < famillyMembers; i++) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Thành viên thứ:  " + (i + 1));
            System.out.println("Họ và tên: ");
            name = scanner1.nextLine();
            System.out.println("Sinh nhật: ");
            birthDay = scanner1.nextLine();
            System.out.println("Nghê nghiệp: ");
            job = scanner1.nextLine();
            members.add(new Person(name, birthDay, job));
        }

        return new Familly(famillyMembers, address, members);
    }
}
