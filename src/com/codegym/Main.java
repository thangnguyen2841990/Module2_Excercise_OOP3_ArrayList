package com.codegym;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FamillyMangement famillyMangement = new FamillyMangement();
        int choice;
        try {
            famillyMangement.readFile("familly2.txt");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        do {
            famillyMangement.menu();
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
                    Familly newFamilly = famillyMangement.inputFamillyInfo();
                    famillyMangement.addNewFamilly(newFamilly);
                    System.out.println("Thêm thành công!");
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
                        Familly newFamilly = famillyMangement.inputFamillyInfo();
                        famillyMangement.updateFamilly(index - 1, newFamilly);
                    }
                    break;
                }
                case 5: {
                    System.out.println("----In ra hộ dân có người mừng thọ 80 tuổi----");
                    famillyMangement.displayOver80YearsOld();
                    break;
                }
            }
            try {
                famillyMangement.writeToFile(famillyMangement.getFamillies());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice != 0);

    }



}
