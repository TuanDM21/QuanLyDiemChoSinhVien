package com.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.model.Lop;
import com.model.SinhVien;
import com.service.GiaoVienService;
import com.service.LopService;

public class InfomationStudents {

	public static void managerStudent() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("---- Menu ----");
			System.out.println("1. Thêm mới sinh viên");
			System.out.println("2. Xoá sinh viên ");
			System.out.println("3. Cập nhật thông tin sinh viên");
			System.out.println("4. Tìm kiếm thông tin sinh viên");
			System.out.println("5. Trở lại trước đó ");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addNewSinhVien();
				getThongtin();
				break;
			case 2:
				getThongtin();
				deleteSinhVien();
				getThongtin();
				break;
			case 3:
				getThongtin();
				updateSinhVien();
				break;
			case 4:
				searchSinhVien();
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
		GiaoVienService gvServices = new GiaoVienService();
		List<SinhVien> listSinhVien = null;
		try {
			listSinhVien = gvServices.getAllSinhVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf("%-10s%-20s%-15s%-30s%-10s%-10s\n", "Mã SV", "Tên SV", "Ngày sinh", "Địa chỉ", "Giới tính",
				"Mã lớp");
		if (listSinhVien != null) {
			for (SinhVien sv : listSinhVien) {
				System.out.printf("%-10d%-20s%-15s%-30s%-10s%-10s\n", sv.getMaSinhVien(), sv.getTenSinhVien(),
						sv.getNgaySinh(), sv.getDiaChi(), sv.getGioiTinh(), sv.getMaLop());
			}
		}
	}

	public static void addNewSinhVien() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thêm sinh viên mới:");
		System.out.print("Tên sinh viên: ");
		String tenSinhVien = scanner.nextLine();
		System.out.print("Ngày sinh: ");
		String ngaySinh = scanner.nextLine();
		System.out.print("Địa chỉ: ");
		String diaChi = scanner.nextLine();
		System.out.print("Giới tính: ");
		String gioiTinh = scanner.nextLine();

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

		// Thêm sinh viên mới
		GiaoVienService gvService = new GiaoVienService();
		try {
			gvService.addSinhVien(tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop);
			System.out.println(" Thêm sinh viên thành công ");
		} catch (Exception e) {
			System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
		}

	}

	public static void deleteSinhVien() {
		Scanner scanner = new Scanner(System.in);
		GiaoVienService gvServices = new GiaoVienService();
		System.out.println(" Lưu ý: Hành động này sẽ xoá luôn thông tin điểm của sinh viên đó.  ");
		System.out.print(" Nhập mã sinh viên bạn muốn xoá: ");
		int maSinhVien = scanner.nextInt();
		try {
			gvServices.deleteSinhVien(maSinhVien);
			System.out.println(" Đã xoá thành công sinh viên với mã sinh viên = " + maSinhVien);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateSinhVien() {
		Scanner scanner = new Scanner(System.in);
		GiaoVienService gvServices = new GiaoVienService();
		List<SinhVien> danhSachSinhVien = null;
		try {
			danhSachSinhVien = gvServices.getAllSinhVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cập nhật thông tin sinh viên:");
		System.out.print("Nhập mã sinh viên: ");
		int maSinhVien = scanner.nextInt();

		scanner.nextLine(); // đọc kí tự xuống dòng được nhập vào sau mã sinh viên

		boolean found = false;
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getMaSinhVien() == maSinhVien) {
				System.out.print("Tên sinh viên mới: ");
				String tenSinhVien = scanner.nextLine();
				sv.setTenSinhVien(tenSinhVien);

				System.out.print("Ngày sinh mới: ");
				String ngaySinh = scanner.nextLine();
				sv.setNgaySinh(ngaySinh);

				System.out.print("Địa chỉ mới: ");
				String diaChi = scanner.nextLine();
				sv.setDiaChi(diaChi);

				System.out.print("Giới tính mới: ");
				String gioiTinh = scanner.nextLine();
				sv.setGioiTinh(gioiTinh);

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
				sv.setMaLop(maLop);

				found = true;

				try {
					gvServices.updateSinhVien(maSinhVien, tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop);
					System.out.print(" Cập nhật thông tin thành công ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}
		}

		if (found) {
			System.out.printf("%-10s%-20s%-15s%-30s%-10s%-10s\n", "Mã SV", "Tên SV", "Ngày sinh", "Địa chỉ",
					"Giới tính", "Mã lớp");
			for (SinhVien s : danhSachSinhVien) {
				System.out.printf("%-10d%-20s%-15s%-30s%-10s%-10s\n", s.getMaSinhVien(), s.getTenSinhVien(),
						s.getNgaySinh(), s.getDiaChi(), s.getGioiTinh(), s.getMaLop());
			}
		} else {
			System.out.println("Không tìm thấy sinh viên với mã số đã nhập.");
		}
	}

	public static void searchSinhVien() {
		Scanner scanner = new Scanner(System.in);
		GiaoVienService gvServices = new GiaoVienService();
		System.out.print("Nhập mã sinh viên hoặc tên bạn muốn tìm: ");
		String key = scanner.nextLine();
		List<SinhVien> listSinhVien = null;
		try {
			listSinhVien = gvServices.searchSinhVien(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf("%-10s%-20s%-15s%-30s%-10s%-10s\n", "Mã SV", "Tên SV", "Ngày sinh", "Địa chỉ", "Giới tính",
				"Mã lớp");
		if (listSinhVien != null) {
			for (SinhVien sv : listSinhVien) {
				System.out.printf("%-10d%-20s%-15s%-30s%-10s%-10s\n", sv.getMaSinhVien(), sv.getTenSinhVien(),
						sv.getNgaySinh(), sv.getDiaChi(), sv.getGioiTinh(), sv.getMaLop());
			}
		}

	}

	

}
