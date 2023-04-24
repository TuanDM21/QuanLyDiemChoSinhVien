package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.GiaoVien;

public class AdminDao {
	public void addGiaoVien(String tenGiaoVien, String ngaySinh, String tenDangNhap, String matKhau, Boolean isAdmin,
			String gioiTinh) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO giaovien(tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin, gioiTinh) VALUES (?, ?, ?, ? ,?,?)";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, tenGiaoVien);
		cmd.setString(2, ngaySinh);
		cmd.setString(3, tenDangNhap);
		cmd.setString(4, matKhau);
		cmd.setBoolean(5, isAdmin);
		cmd.setString(6, gioiTinh);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void updateGiaoVien(int maGiaoVien, String tenGiaoVien, String ngaySinh, String tenDangNhap, String matKhau,
			Boolean isAdmin, String gioiTinh) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "UPDATE giaovien SET tenGiaoVien = ?, ngaySinh = ?, tenDangNhap = ?, matKhau = ?, isAdmin = ?, gioiTinh = ? WHERE maGiaoVien = ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, tenGiaoVien);
		cmd.setString(2, ngaySinh);
		cmd.setString(3, tenDangNhap);
		cmd.setString(4, matKhau);
		cmd.setBoolean(5, isAdmin);
		cmd.setString(6, gioiTinh);
		cmd.setInt(7, maGiaoVien);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void deleteGiaoVien(int maGiaoVien) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "DELETE FROM giaovien WHERE maGiaoVien = ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, maGiaoVien);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public List<GiaoVien> getAllGiaoVien() throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM giaovien ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		List<GiaoVien> listGiaoVien = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maGiaoVien = rs.getInt("maGiaoVien");
			String tenGiaoVien = rs.getString("tenGiaoVien");
			String ngaySinh = rs.getString("ngaySinh");
			String tenDangNhap = rs.getString("tenDangNhap");
			String matKhau = rs.getString("matKhau");
			String gioiTinh = rs.getString("gioiTinh");
			Boolean isAdmin = rs.getBoolean("isAdmin");
			listGiaoVien.add(new GiaoVien(maGiaoVien, tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin, gioiTinh));
		}
		connect.cn.close();
		return listGiaoVien;
	}

	public List<GiaoVien> searchGiaoVien(String key) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM giaovien WHERE tenGiaoVien LIKE ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, "%" + key + "%");
		List<GiaoVien> listGiaoVien = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maGiaoVien = rs.getInt("maGiaoVien");
			String tenGiaoVien = rs.getString("tenGiaoVien");
			String ngaySinh = rs.getString("ngaySinh");
			String tenDangNhap = rs.getString("tenDangNhap");
			String matKhau = rs.getString("matKhau");
			String gioiTinh = rs.getString("gioiTinh");
			Boolean isAdmin = rs.getBoolean("isAdmin");
			listGiaoVien.add(new GiaoVien(maGiaoVien, tenGiaoVien, ngaySinh, tenDangNhap, matKhau, isAdmin, gioiTinh));
		}
		connect.cn.close();
		return listGiaoVien;
	}
}
