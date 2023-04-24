package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.GiaoVien;
import com.service.AdminService;
import com.service.GiaoVienService;

public class TeacherInfomation {
	public static void managerTeacher() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("---- Menu ----");
			System.out.println("1. Thêm mới giáo viên");
			System.out.println("2. Xoá giáo viên ");
			System.out.println("3. Cập nhật thông tin giáo viên");
			System.out.println("4. Tìm kiếm thông tin giáo viên");
			System.out.println("5. Trở lại trước đó ");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addNewGiaoVien();
				getThongtin();
				break;
			case 2:
				getThongtin();
				deleteGiaoVien();
				getThongtin();
				break;
			case 3:
				getThongtin();
				updateGiaoVien();
				break;
			case 4:
				getThongtin();
				searchGiaoVien();
				break;
			case 5:
				MenuSystem.MenuSystemStudent();
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 6);
		scanner.close();
	}

	public static void getThongtin() {
		AdminService adminServices = new AdminService();
		List<GiaoVien> listGiaoVien = null;
		try {
			listGiaoVien = adminServices.getAllGiaoVien();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.printf("%-10s%-20s%-15s%-20s%-20s%-10s%-10s\n", "Mã GV", "Tên GV", "Ngày sinh", "Tên đăng nhập",
				"Mật khẩu", "Admin", "Giới tính");
		if (listGiaoVien != null) {
			for (GiaoVien gv : listGiaoVien) {
				System.out.printf("%-10d%-20s%-15s%-20s%-20s%-10s%-10s\n", gv.getMaGiaoVien(), gv.getTenGiaoVien(),
						gv.getNgaySinh(), gv.getTenDangNhap(), gv.getMatKhau(), gv.getIsAdmin(), gv.getGioiTinh());
			}
		}
	}

	public static void addNewGiaoVien() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm giáo viên mới:");
		System.out.print("Tên giáo viên: ");
		String tenGiaoVien = scanner.nextLine();
		System.out.print("Ngày sinh: ");
		String ngaySinh = scanner.nextLine();
		System.out.print("Tên đăng nhập: ");
		String tenDangNhap = scanner.nextLine();
		System.out.print("Mật khẩu: ");
		String matKhau = scanner.nextLine();
		System.out.print("Giới tính: ");
		String gioiTinh = scanner.nextLine();
		System.out.print("Admin (true/false): ");
		Boolean isAdmin = scanner.nextBoolean();

		// Thêm giáo viên mới
		AdminService adminServices = new AdminService();
		try {
			adminServices.addGiaoVien(tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin, gioiTinh);
			System.out.println("Thêm giáo viên thành công!");
		} catch (Exception e) {
			System.out.println("Lỗi khi thêm giáo viên: " + e.getMessage());
		}
	}

	public static void deleteGiaoVien() {
		Scanner scanner = new Scanner(System.in);
		AdminService adminServices = new AdminService();
		System.out.print("Nhập mã giáo viên bạn muốn xoá: ");
		int maGiaoVien = scanner.nextInt();
		try {
			adminServices.deleteGiaoVien(maGiaoVien);
			System.out.println("Đã xoá thành công giáo viên với mã giáo viên = " + maGiaoVien);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateGiaoVien() {
		Scanner scanner = new Scanner(System.in);
		AdminService adminServices = new AdminService();
		List<GiaoVien> danhSachGiaoVien = null;
		try {
			danhSachGiaoVien = adminServices.getAllGiaoVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cập nhật thông tin giáo viên:");
		System.out.print("Nhập mã giáo viên: ");
		int maGiaoVien = scanner.nextInt();

		scanner.nextLine(); // đọc kí tự xuống dòng được nhập vào sau mã giáo viên

		boolean found = false;
		for (GiaoVien gv : danhSachGiaoVien) {
			if (gv.getMaGiaoVien() == maGiaoVien) {
				System.out.print("Tên giáo viên mới: ");
				String tenGiaoVien = scanner.nextLine();
				gv.setTenGiaoVien(tenGiaoVien);

				System.out.print("Ngày sinh mới: ");
				String ngaySinh = scanner.nextLine();
				gv.setNgaySinh(ngaySinh);

				System.out.print("Tên đăng nhập mới: ");
				String tenDangNhap = scanner.nextLine();
				gv.setTenDangNhap(tenDangNhap);

				System.out.print("Mật khẩu mới: ");
				String matKhau = scanner.nextLine();
				gv.setMatKhau(matKhau);

				System.out.print("Có quyền admin hay không (true/false): ");
				Boolean isAdmin = scanner.nextBoolean();
				gv.setIsAdmin(isAdmin);

				System.out.print("Giới tính mới: ");
				String gioiTinh = scanner.nextLine();
				gv.setGioiTinh(gioiTinh);

				found = true;

				try {
					adminServices.updateGiaoVien(maGiaoVien, tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin,
							gioiTinh);
					System.out.print(" Cập nhật thông tin thành công ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}
		}

		if (found) {
			System.out.printf("%-10s%-20s%-15s%-20s%-15s%-10s%-10s\n", "Mã GV", "Tên GV", "Ngày sinh", "Tên đăng nhập",
					"Mật khẩu", "Admin", "Giới tính");
			for (GiaoVien g : danhSachGiaoVien) {
				System.out.printf("%-10d%-20s%-15s%-20s%-15s%-10s%-10s\n", g.getMaGiaoVien(), g.getTenGiaoVien(),
						g.getNgaySinh(), g.getTenDangNhap(), g.getMatKhau(), g.getIsAdmin(), g.getGioiTinh());
			}
		} else {
			System.out.println("Không tìm thấy giáo viên với mã số đã nhập.");
		}
	}

	public static void searchGiaoVien() {
		Scanner scanner = new Scanner(System.in);
		AdminService adminServices = new AdminService();
		System.out.print("Nhập tên bạn muốn tìm: ");
		String key = scanner.nextLine();
		List<GiaoVien> listGiaoVien = null;
		try {
			listGiaoVien = adminServices.searchGiaoVien(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%-10s%-20s%-15s%-20s%-20s%-10s%-10s\n", "Mã GV", "Tên GV", "Ngày sinh", "Tên đăng nhập",
				"Mật khẩu", "Admin", "Giới tính");
		if (listGiaoVien != null) {
			for (GiaoVien gv : listGiaoVien) {
				System.out.printf("%-10d%-20s%-15s%-20s%-20s%-10s%-10s\n", gv.getMaGiaoVien(), gv.getTenGiaoVien(),
						gv.getNgaySinh(), gv.getTenDangNhap(), gv.getMatKhau(), gv.getIsAdmin(), gv.getGioiTinh());
			}
		}

	}

}
