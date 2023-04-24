package com.service;

import java.util.List;

import com.dao.DiemRenLuyenDao;
import com.model.DiemRenLuyen;

public class DiemRenLuyenService {
	DiemRenLuyenDao dao = new DiemRenLuyenDao();

	public List<DiemRenLuyen> getAllDiemRenLuyen() throws Exception {
		return dao.getAllDiemRenLuyen();
	}

	public void deleteDiemRenLuyenbyMaSinhVien(int maSinhVien) throws Exception {
		dao.deleteDiemRenLuyenbyMaSinhVien(maSinhVien);
	}

	public void addDiemRenLuyen(float diemRenLuyen, int hocKi, int maSinhVien) throws Exception {
		dao.addDiemRenLuyen(diemRenLuyen, hocKi, maSinhVien);
	}

	public void updateDiemRenLuyen(int maSinhVien, float diemRenLuyen, int hocKi, int maDiemRenLuyen) throws Exception {
		dao.updateDiemRenLuyen(maSinhVien, diemRenLuyen, hocKi, maDiemRenLuyen);
	}

	public void deleteDiemRenLuyenbyMaDiemRenLuyen(int maDiemRenLuyen) throws Exception {
		dao.deleteDiemRenLuyenbyMaDiemRenLuyen(maDiemRenLuyen);
	}

	public List<DiemRenLuyen> getAllDiemRenLuyenByKhoa(String maKhoa) throws Exception {
		return dao.getAllDiemRenLuyenByKhoa(maKhoa);
	}

	public List<DiemRenLuyen> getAllDiemRenLuyenByLop(String maLop) throws Exception {
		return dao.getAllDiemRenLuyenByLop(maLop);
	}

}
