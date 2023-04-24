package com.service;

import java.util.List;

import com.dao.AdminDao;
import com.model.GiaoVien;

public class AdminService {

	AdminDao dao = new AdminDao();

	public void addGiaoVien(String tenGiaoVien, String ngaySinh, String tenDangNhap, String matKhau, Boolean isAdmin,
			String gioiTinh) throws Exception {
		dao.addGiaoVien(tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin, gioiTinh);
	}

	public void updateGiaoVien(int maGiaoVien, String tenGiaoVien, String ngaySinh, String tenDangNhap, String matKhau,
			Boolean isAdmin, String gioiTinh) throws Exception {
		dao.updateGiaoVien(maGiaoVien, tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin, gioiTinh);
	}

	public void deleteGiaoVien(int maGiaoVien) throws Exception {
		dao.deleteGiaoVien(maGiaoVien);
	}

	public List<GiaoVien> searchGiaoVien(String key) throws Exception {
		return dao.searchGiaoVien(key);
	}

	public List<GiaoVien> getAllGiaoVien() throws Exception {
		return dao.getAllGiaoVien();
	}

}
