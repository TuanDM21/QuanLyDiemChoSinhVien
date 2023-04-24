package com.view;

import java.util.Scanner;

import com.service.GiaoVienService;

// Dành cho 
public class MenuSystemTeacher {
	public static void MenuSystem() {

		System.out.println(" ---- Chào mừng bạn đến với hệ thống quản lý của quản trị viên ---- ");
		GiaoVienService gvService = new GiaoVienService();
		Scanner scanner = new Scanner(System.in);
		int choice;

		System.out.println("---- Menu ----");
		System.out.println("1. Quản lý thông tin giáo viên ");
		System.out.println("2. Exit");
		System.out.print("Enter your choice: ");

		choice = scanner.nextInt();

		switch (choice) {
		case 1:
			try {
				TeacherInfomation.managerTeacher();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
			break;
		}
		scanner.close();
	}
}
