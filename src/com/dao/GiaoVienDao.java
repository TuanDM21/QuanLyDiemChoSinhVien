package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.GiaoVien;
import com.model.SinhVien;
import com.service.DiemRenLuyenService;

public class GiaoVienDao {

	public void addSinhVien(String tenSinhVien, String ngaySinh, String diaChi, String gioiTinh, String maLop)
			throws Exception {
		// Tạo đối tượng kết nối
		ConnectDB connect = new ConnectDB();
		// Kết nối đến database
		connect.KetNoi();
		// Câu sql
		String sql = "INSERT INTO sinhvien(tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop) VALUES (?, ?, ?, ? ,?)";
		// Đối tượng PreparedStatement
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		// Set parameter
		cmd.setString(1, tenSinhVien);
		cmd.setString(2, ngaySinh);
		cmd.setString(3, diaChi);
		cmd.setString(4, gioiTinh);
		cmd.setString(5, maLop);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void updateSinhVien(int maSinhVien, String tenSinhVien, String ngaySinh, String diaChi, String gioiTinh,
			String maLop) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Update sinhvien set tenSinhVien = ? , ngaySinh = ?, diaChi =? , maLop = ?, gioiTinh = ?  where maSinhVien = ? ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, tenSinhVien);
		cmd.setString(2, ngaySinh);
		cmd.setString(3, diaChi);
		cmd.setString(4, maLop);
		cmd.setString(5, gioiTinh);
		cmd.setInt(6, maSinhVien);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void deleteSinhVien(int maSinhVien) throws Exception {
		DiemRenLuyenService diemService = new DiemRenLuyenService();
		diemService.deleteDiemRenLuyenbyMaSinhVien(maSinhVien);
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Delete from sinhvien where maSinhVien = ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, maSinhVien);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public List<SinhVien> getAllSinhVien() throws Exception {
		// Tạo đối tượng kết nối
		ConnectDB connect = new ConnectDB();
		// Kết nối đến database
		connect.KetNoi();
		// Câu sql
		String sql = "Select * from sinhvien ";
		// Đối tượng PreparedStatement
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		List<SinhVien> listSinhVien = new ArrayList<>();
		// Lấy dữ liệu theo index trong DB 
		ResultSet rs = cmd.executeQuery();
		// Nếu có thì set dữ liệu 
		while (rs.next()) {
			int maSinhVien = rs.getInt("maSinhVien");
			String tenSinhVien = rs.getString("tenSinhVien");
			String ngaySinh = rs.getString("ngaySinh");
			String diaChi = rs.getString("diaChi");
			String maLop = rs.getString("maLop");
			String gioiTinh = rs.getString("gioiTinh");
			listSinhVien.add(new SinhVien(maSinhVien, tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop));
		}
		connect.cn.close();
		return listSinhVien;
	}

	public List<SinhVien> searchSinhVien(String key) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM sinhvien WHERE maSinhVien LIKE ? OR tenSinhVien LIKE ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, "%" + key + "%");
		cmd.setString(2, "%" + key + "%");
		List<SinhVien> listSinhVien = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maSinhVien = rs.getInt("maSinhVien");
			String tenSinhVien = rs.getString("tenSinhVien");
			String ngaySinh = rs.getString("ngaySinh");
			String diaChi = rs.getString("diaChi");
			String maLop = rs.getString("maLop");
			String gioiTinh = rs.getString("gioiTinh");
			listSinhVien.add(new SinhVien(maSinhVien, tenSinhVien, ngaySinh, diaChi, gioiTinh, maLop));
		}

		connect.cn.close();
		return listSinhVien;
	}

	public String getTenSinhVienFromMaSinhVien(int maSinhVien) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM sinhvien WHERE maSinhVien = ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, maSinhVien);
		ResultSet rs = cmd.executeQuery();
		String tenSinhVien = null;
		if (rs.next()) {
			tenSinhVien = rs.getString("tenSinhVien");
		}

		connect.cn.close();
		return tenSinhVien;
	}

	public GiaoVien Login(String tenDangNhap, String matKhau) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM GiaoVien WHERE tenDangNhap = ? and matKhau = ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, tenDangNhap);
		cmd.setString(2, matKhau);
		GiaoVien giaoVien = new GiaoVien();
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			giaoVien.setMaGiaoVien(rs.getInt("maGiaoVien"));
			giaoVien.setNgaySinh(rs.getString("ngaySinh"));
			giaoVien.setTenGiaoVien(rs.getString("tenGiaoVien"));
			giaoVien.setIsAdmin(rs.getBoolean("isAdmin"));
		}

		connect.cn.close();
		return giaoVien;
	}

}
