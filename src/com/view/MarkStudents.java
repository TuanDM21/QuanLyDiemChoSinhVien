package com.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.model.DiemRenLuyen;
import com.model.SinhVien;
import com.service.DiemRenLuyenService;
import com.service.GiaoVienService;

public class MarkStudents {

	public static void markStudent() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("---- Menu ----");
			System.out.println("1. Lấy tất cả điểm của sinh viên");
			System.out.println("2. Thêm điểm cho sinh viên");
			System.out.println("3. Cập nhật điểm sinh viên ");
			System.out.println("4. Xoá điểm rèn luyện của sinh viên ");
			System.out.println("5. Thống kê điểm: ");
			System.out.println("6. Trở lại trước đó");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayDiemRenLuyenAndTenSinhVien();
				break;
			case 2:
				addNewDiemRenLuyen();
				displayDiemRenLuyenAndTenSinhVien();
				break;
			case 3:
				displayDiemRenLuyenAndTenSinhVien();
				updateDiemRenLuyen();
				displayDiemRenLuyenAndTenSinhVien();
				break;
			case 4:
				displayDiemRenLuyenAndTenSinhVien();
				deleteDiemRenLuyen();
				displayDiemRenLuyenAndTenSinhVien();
				break;
			case 5:
				StatisticalMark.StatisticalMarkStudent();
				break;
			case 6:
				MenuSystem.MenuSystemStudent();
				break;
			case 7:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 7);
		scanner.close();
	}

	public static void displayDiemRenLuyenAndTenSinhVien() {
		DiemRenLuyenService diemService = new DiemRenLuyenService();
		GiaoVienService gvService = new GiaoVienService();
		List<DiemRenLuyen> diemRenLuyenList = null;
		try {
			diemRenLuyenList = diemService.getAllDiemRenLuyen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mã điểm rèn luyện | Điểm Rèn Luyện | Học Kì | Mã Sinh Viên | Tên Sinh Viên");
		for (DiemRenLuyen diemRenLuyen : diemRenLuyenList) {
			String tenSinhVien = null;
			try {
				tenSinhVien = gvService.getTenSinhVienFromMaSinhVien(diemRenLuyen.getMaSinhVien());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("%-17d%-17.1f%-9d%-14s%s\n", diemRenLuyen.getMaDiemRenLuyen(),
					diemRenLuyen.getDiemRenLuyen(), diemRenLuyen.getHocKi(), diemRenLuyen.getMaSinhVien(), tenSinhVien);
		}
	}

	public static void addNewDiemRenLuyen() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm điểm rèn luyện mới:");

		// Get list of SinhVien from database
		GiaoVienService gvService = new GiaoVienService();
		List<SinhVien> listSinhVien;
		try {
			listSinhVien = gvService.getAllSinhVien();
		} catch (Exception e) {
			System.out.println("Lỗi khi lấy danh sách sinh viên: " + e.getMessage());
			return;
		}

		Map<Integer, String> mapSinhVien = new HashMap<>();
		for (SinhVien sv : listSinhVien) {
			System.out.println(sv.getMaSinhVien() + " - " + sv.getTenSinhVien());
			mapSinhVien.put(sv.getMaSinhVien(), sv.getTenSinhVien());
		}
		System.out.print("Chọn sinh viên theo mã: ");
		int maSinhVien = scanner.nextInt();
		scanner.nextLine(); // Đọc kí tự '\n' bị lưu lại trong bộ nhớ đệm
		if (!mapSinhVien.containsKey(maSinhVien)) {
			System.out.println("Sinh viên không tồn tại!");
			return;
		}

		// Get diemRenLuyen, hocKi from user input
		System.out.print("Điểm rèn luyện: ");
		float diemRenLuyen = scanner.nextFloat();
		scanner.nextLine(); // consume newline
		System.out.print("Học kì: ");
		int hocKi = scanner.nextInt();
		scanner.nextLine(); // consume newline

		DiemRenLuyenService diemRenLuyenService = new DiemRenLuyenService();
		try {
			diemRenLuyenService.addDiemRenLuyen(diemRenLuyen, hocKi, maSinhVien);
			System.out.println(" Thêm điểm rèn luyện thành công ");
		} catch (Exception e) {
			System.out.println("Lỗi khi thêm điểm rèn luyện: " + e.getMessage());
		}
	}

	public static void updateDiemRenLuyen() {
		Scanner scanner = new Scanner(System.in);
		DiemRenLuyenService drlService = new DiemRenLuyenService();
		GiaoVienService gvService = new GiaoVienService();

		List<SinhVien> listSinhVien;
		try {
			listSinhVien = gvService.getAllSinhVien();
		} catch (Exception e) {
			System.out.println("Lỗi khi lấy danh sách sinh viên: " + e.getMessage());
			return;
		}

		List<DiemRenLuyen> danhSachDiemRenLuyen = null;
		try {
			danhSachDiemRenLuyen = drlService.getAllDiemRenLuyen();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Cập nhật điểm rèn luyện:");
		System.out.print("Nhập mã điểm rèn luyện : ");
		int maDiemRenLuyen = scanner.nextInt();
		scanner.nextLine();

		boolean found = false;
		for (DiemRenLuyen drl : danhSachDiemRenLuyen) {
			if (drl.getMaDiemRenLuyen() == maDiemRenLuyen) {
				System.out.print("Nhập điểm rèn luyện mới: ");
				float diemRenLuyen = scanner.nextFloat();

				System.out.print("Nhập học kì mới: ");
				int hocKi = scanner.nextInt();

				Map<Integer, String> mapSinhVien = new HashMap<>();
				for (SinhVien sv : listSinhVien) {
					System.out.println(sv.getMaSinhVien() + " - " + sv.getTenSinhVien());
					mapSinhVien.put(sv.getMaSinhVien(), sv.getTenSinhVien());
				}
				System.out.print("Chọn sinh viên theo mã: ");
				int maSinhVien = scanner.nextInt();
				scanner.nextLine(); // Đọc kí tự '\n' bị lưu lại trong bộ nhớ đệm
				if (!mapSinhVien.containsKey(maSinhVien)) {
					System.out.println("Sinh viên không tồn tại!");
					return;
				}

				found = true;

				try {
					drlService.updateDiemRenLuyen(maSinhVien, diemRenLuyen, hocKi, maDiemRenLuyen);
					System.out.println("Cập nhật thông tin thành công");

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sinh viên với mã số đã nhập.");
		}
	}

	public static void deleteDiemRenLuyen() {
		Scanner scanner = new Scanner(System.in);
		DiemRenLuyenService drlService = new DiemRenLuyenService();
		GiaoVienService gvService = new GiaoVienService();

		List<DiemRenLuyen> danhSachDiemRenLuyen = null;
		try {
			danhSachDiemRenLuyen = drlService.getAllDiemRenLuyen();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.print("Nhập mã điểm rèn luyện : ");
		int maDiemRenLuyen = scanner.nextInt();
		scanner.nextLine();

		boolean found = false;
		for (DiemRenLuyen drl : danhSachDiemRenLuyen) {
			if (drl.getMaDiemRenLuyen() == maDiemRenLuyen) {

				found = true;

				try {
					drlService.deleteDiemRenLuyenbyMaDiemRenLuyen(maDiemRenLuyen);
					System.out.println("Xoá thông tin thành công");

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sinh viên với mã số đã nhập.");
		}

	}
}
