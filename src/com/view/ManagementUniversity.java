package com.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.model.GiaoVien;
import com.service.GiaoVienService;

// Menu tổng 
public class ManagementUniversity {

	public static void main(String[] args) {
		System.out.println(" ---- Đăng nhập để tiếp tục ---- ");
		GiaoVienService gvService = new GiaoVienService();
		Scanner scanner = new Scanner(System.in);

		int choice;

		do {
			System.out.println("---- Menu ----");
			System.out.println("1. Đăng nhập ");
			System.out.print(" Lựa chọn : ");

			choice = scanner.nextInt();
			switch (choice) {
			case 1:

				boolean loginStatus = false;

				while (loginStatus == false) {
					System.out.print("Nhập username: ");
					String username = scanner.next();
					System.out.print("Nhập password: ");
					String password = scanner.next();
					try {
						loginStatus = true;
						GiaoVien gv = gvService.Login(username, password);
						if (gv.getMaGiaoVien() > 0) {
							System.out.println(" Xin chào " + gv.getTenGiaoVien());
							if (gv.getIsAdmin() == false) {
								MenuSystem.MenuSystemStudent();
							} else {
								MenuSystemTeacher.MenuSystem();
							}
						} else {
							System.out.println(" Sai tài khoản hoặc mật khẩu. Vui lòng chạy lại hệ thống... ");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				break;
			case 2:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}

		while (choice != 2);

	}

}
