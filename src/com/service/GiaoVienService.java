package com.service;

import java.util.List;

import com.dao.GiaoVienDao;
import com.model.GiaoVien;
import com.model.SinhVien;

public class GiaoVienService {

	GiaoVienDao gvDao = new GiaoVienDao();

	public void addSinhVien(String tenSinhVien, String ngaySinh, String diaChi, String gioiTinh, String maLop)
			throws Exception {
		gvDao.addSinhVien(tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop);
	}

	public void updateSinhVien(int maSinhVien, String tenSinhVien, String ngaySinh, String diaChi, String gioiTinh,
			String maLop) throws Exception {
		gvDao.updateSinhVien(maSinhVien, tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop);
	}

	public void deleteSinhVien(int maSinhVien) throws Exception {
		gvDao.deleteSinhVien(maSinhVien);
	}

	public List<SinhVien> getAllSinhVien() throws Exception {
		return gvDao.getAllSinhVien();
	}

	public List<SinhVien> searchSinhVien(String key) throws Exception {
		return gvDao.searchSinhVien(key);
	}

	public String getTenSinhVienFromMaSinhVien(int maSinhVien) throws Exception {
		return gvDao.getTenSinhVienFromMaSinhVien(maSinhVien);
	}

	public GiaoVien Login(String tenDangNhap, String matKhau) throws Exception {
		return gvDao.Login(tenDangNhap, matKhau);
	}

}
