package com.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.model.DiemRenLuyen;
import com.model.Khoa;
import com.model.Lop;
import com.service.DiemRenLuyenService;
import com.service.GiaoVienService;
import com.service.KhoaService;
import com.service.LopService;

public class StatisticalMark {

	public static void StatisticalMarkStudent() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("---- Thống Kê ----");
			System.out.println("1. Thống kê học lực ");
			System.out.println("2. Thống kê theo lớp");
			System.out.println("3. Thống kê theo khoa");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayHocLuc();
				break;
			case 2:
				displayHocLucTheoLop();
				break;
			case 3:
				displayHocLucTheoKhoa();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 4);
		scanner.close();
	}

	public static void displayHocLuc() {
		DiemRenLuyenService diemService = new DiemRenLuyenService();
		GiaoVienService gvService = new GiaoVienService();
		List<DiemRenLuyen> diemRenLuyenList = null;
		try {
			diemRenLuyenList = diemService.getAllDiemRenLuyen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Mã điểm rèn luyện | Điểm Rèn Luyện | Học Kì | Mã Sinh Viên | Tên Sinh Viên | Học Lực");
		for (DiemRenLuyen diemRenLuyen : diemRenLuyenList) {
			String tenSinhVien = null;
			String hocLuc = null;
			try {
				tenSinhVien = gvService.getTenSinhVienFromMaSinhVien(diemRenLuyen.getMaSinhVien());
			} catch (Exception e) {
				e.printStackTrace();
			}
			double diem = diemRenLuyen.getDiemRenLuyen();
			if (diem >= 8.0) {
				hocLuc = "Giỏi";
			} else if (diem >= 6.5) {
				hocLuc = "Khá";
			} else {
				hocLuc = "Trung bình";
			}
			System.out.printf("%-17d%-17.1f%-9d%-14s%-15s%s\n", diemRenLuyen.getMaDiemRenLuyen(),
					diemRenLuyen.getDiemRenLuyen(), diemRenLuyen.getHocKi(), diemRenLuyen.getMaSinhVien(), tenSinhVien,
					hocLuc);
		}
	}

	public static void displayHocLucTheoLop() {
		Scanner scanner = new Scanner(System.in);
		// Lấy danh sách lớp
		LopService lopService = new LopService();
		List<Lop> listLop;
		try {
			listLop = lopService.getAllLop();
		} catch (Exception e) {
			System.out.println("Lỗi khi lấy danh sách lớp: " + e.getMessage());
			return;
		}

		// Hiển thị danh sách lớp và cho người dùng chọn
		System.out.println("Danh sách lớp:");
		Map<String, String> mapLop = new HashMap<>();
		for (Lop lop : listLop) {
			System.out.println(lop.getTenLop() + " - " + lop.getMaLop());
			mapLop.put(lop.getTenLop(), lop.getMaLop());
		}
		System.out.print("Chọn lớp: ");
		String tenLop = scanner.nextLine();
		if (!mapLop.containsKey(tenLop)) {
			System.out.println("Lớp không tồn tại!");
			return;
		}
		String maLop = mapLop.get(tenLop);
		DiemRenLuyenService diemService = new DiemRenLuyenService();
		GiaoVienService gvService = new GiaoVienService();
		List<DiemRenLuyen> diemRenLuyenList = null;
		try {
			diemRenLuyenList = diemService.getAllDiemRenLuyenByLop(maLop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Mã điểm rèn luyện | Điểm Rèn Luyện | Học Kì | Mã Sinh Viên | Tên Sinh Viên | Học Lực");
		for (DiemRenLuyen diemRenLuyen : diemRenLuyenList) {
			String tenSinhVien = null;
			String hocLuc = null;
			try {
				tenSinhVien = gvService.getTenSinhVienFromMaSinhVien(diemRenLuyen.getMaSinhVien());
			} catch (Exception e) {
				e.printStackTrace();
			}
			double diem = diemRenLuyen.getDiemRenLuyen();
			if (diem >= 8.0) {
				hocLuc = "Giỏi";
			} else if (diem >= 6.5) {
				hocLuc = "Khá";
			} else {
				hocLuc = "Trung bình";
			}
			System.out.printf("%-17d%-17.1f%-9d%-14s%-15s%s\n", diemRenLuyen.getMaDiemRenLuyen(),
					diemRenLuyen.getDiemRenLuyen(), diemRenLuyen.getHocKi(), diemRenLuyen.getMaSinhVien(), tenSinhVien,
					hocLuc);
		}
	}

	public static void displayHocLucTheoKhoa() {
		Scanner scanner = new Scanner(System.in);
		// Lấy danh sách lớp
		KhoaService khoaService = new KhoaService();
		List<Khoa> listKhoa;
		try {
			listKhoa = khoaService.getAllKhoa();
		} catch (Exception e) {
			System.out.println("Lỗi khi lấy danh sách khoa: " + e.getMessage());
			return;
		}

		// Hiển thị danh sách lớp và cho người dùng chọn
		System.out.println("Danh sách khoa:");
		Map<String, String> mapKhoa = new HashMap<>();
		for (Khoa khoa : listKhoa) {
			System.out.println(khoa.getTenKhoa() + " - " + khoa.getMaKhoa());
			mapKhoa.put(khoa.getTenKhoa(), khoa.getMaKhoa());
		}
		System.out.print("Chọn khoa: ");
		String tenKhoa = scanner.nextLine();
		if (!mapKhoa.containsKey(tenKhoa)) {
			System.out.println("Khoa không tồn tại!");
			return;
		}
		String maKhoa = mapKhoa.get(tenKhoa);
		DiemRenLuyenService diemService = new DiemRenLuyenService();
		GiaoVienService gvService = new GiaoVienService();
		List<DiemRenLuyen> diemRenLuyenList = null;
		try {
			diemRenLuyenList = diemService.getAllDiemRenLuyenByLop(maKhoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Mã điểm rèn luyện | Điểm Rèn Luyện | Học Kì | Mã Sinh Viên | Tên Sinh Viên | Học Lực");
		for (DiemRenLuyen diemRenLuyen : diemRenLuyenList) {
			String tenSinhVien = null;
			String hocLuc = null;
			try {
				tenSinhVien = gvService.getTenSinhVienFromMaSinhVien(diemRenLuyen.getMaSinhVien());
			} catch (Exception e) {
				e.printStackTrace();
			}
			double diem = diemRenLuyen.getDiemRenLuyen();
			if (diem >= 8.0) {
				hocLuc = "Giỏi";
			} else if (diem >= 6.5) {
				hocLuc = "Khá";
			} else {
				hocLuc = "Trung bình";
			}
			System.out.printf("%-17d%-17.1f%-9d%-14s%-15s%s\n", diemRenLuyen.getMaDiemRenLuyen(),
					diemRenLuyen.getDiemRenLuyen(), diemRenLuyen.getHocKi(), diemRenLuyen.getMaSinhVien(), tenSinhVien,
					hocLuc);
		}
	}

}
