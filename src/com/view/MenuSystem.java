package com.view;

import java.util.Scanner;

import com.service.GiaoVienService;

// Dành cho giáo 
public class MenuSystem {

	public static void MenuSystemStudent() {

		System.out.println(" ---- Chào mừng bạn đến với hệ thống quản lý điểm trường đại học ---- ");
		GiaoVienService gvService = new GiaoVienService();
		Scanner scanner = new Scanner(System.in);
		int choice;

		System.out.println("---- Menu ----");
		System.out.println("1. Quản lý thông tin sinh viên");
		System.out.println("2. Quản lý điểm sinh viên");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");

		choice = scanner.nextInt();

		switch (choice) {
		case 1:
			try {
				InfomationStudents.getThongtin();
				InfomationStudents.managerStudent();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			MarkStudents.markStudent();
			break;
		case 3:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
			break;
		}
		scanner.close();
	}

}
