package com.codegym;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FamillyMangement famillyMangement = new FamillyMangement();
        Familly familly = new Familly();
        int choice;
        menu();
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 6) {
                System.out.println("Menu chỉ có từ 1 => 6");
            }
            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị thông tin các hộ dân----");
                    famillyMangement.displayAllFamillies();
                    break;
                }
                case 2: {
                    System.out.println("----Thêm hộ dân----");
                    System.out.println("Nhập số hộ dân muốn thêm:  ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Hộ dân số: " + (i + 1));
                        Familly newFamilly = inputFamillyInfo();
                        famillyMangement.addNewFamilly(newFamilly);
                    }

                    break;
                }
                case 3: {
                    System.out.println("----Xóa hộ dân----");
                    System.out.println("Nhập vị trí muốn xoa hộ dân: ");
                    int index = scanner.nextInt();
                    if (index - 1 < 0 || index - 1 >= famillyMangement.getFamillies().size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        famillyMangement.removeFamilly(index);
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Cập nhật thông tin hộ dân----");
                    System.out.println("Nhập vị trí muốn cập nhật thông tin hộ dân: ");
                    int index = scanner.nextInt();
                    if (index - 1 < 0 || index - 1 >= famillyMangement.getFamillies().size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Familly newFamilly = inputFamillyInfo();
                        famillyMangement.updateFamilly(index-1,newFamilly);
                    }
                    break;
                }
                case 5: {
                    System.out.println("----In ra hộ dân có người mừng thọ 80 tuổi----");
                    famillyMangement.displayOver80YearsOld();
                    break;
                }
            }
        } while (choice != 6);

    }

    public static void menu() {
        System.out.println("----MENU QUẢN LÝ CÁC HỘ DÂN----");
        System.out.println("1. Hiển thị thông tin các hộ dân.");
        System.out.println("2. Thêm hộ dân");
        System.out.println("3. Xóa hộ dân");
        System.out.println("4. Cập nhật hộ dân");
        System.out.println("5. Hộ dân có người mừng thọ 80 tuổi");
        System.out.println("6. Thoát");
    }

    public static Familly inputFamillyInfo() {
        String name = "";
        String birthDay = "";
        String job = "";
        System.out.println("Nhập thông tin của hộ dân: ");
        System.out.println("Sô thành viên trong nhà: ");
        int famillyMembers = scanner.nextInt();
        System.out.println("Nhập số nhà: ");
        int address = scanner.nextInt();
        System.out.println("Nhập từng thành viên trong gia đình");
        Person[] members = new Person[famillyMembers];
        for (int i = 0; i < members.length; i++) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Thành viên thứ:  " + (i + 1));
            System.out.println("Họ và tên: ");
            name = scanner1.nextLine();
            System.out.println("Sinh nhật: ");
            birthDay = scanner1.nextLine();
            System.out.println("Nghê nghiệp: ");
            job = scanner1.nextLine();
            members[i] = new Person(name, birthDay, job);
        }

        return new Familly(famillyMembers, address, members);
    }

}
