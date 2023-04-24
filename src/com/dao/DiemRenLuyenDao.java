package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.DiemRenLuyen;

public class DiemRenLuyenDao {

	public void addDiemRenLuyen(float diemRenLuyen, int hocKi, int maSinhVien) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO diemrenluyen(diemRenLuyen, hocKi, maSinhVien) VALUES (?, ?, ?)";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setFloat(1, diemRenLuyen);
		cmd.setInt(2, hocKi);
		cmd.setInt(3, maSinhVien);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void updateDiemRenLuyen(int maSinhVien, float diemRenLuyen, int hocKi, int maDiemRenLuyen) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Update diemrenluyen set diemRenLuyen = ?, hocKi = ?, maSinhVien = ? where maDiemRenLuyen =?  ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setFloat(1, diemRenLuyen);
		cmd.setInt(2, hocKi);
		cmd.setInt(3, maSinhVien);
		cmd.setInt(4, maDiemRenLuyen);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public List<DiemRenLuyen> getAllDiemRenLuyen() throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Select * from diemrenluyen";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		List<DiemRenLuyen> listDiemRenLuyen = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maDiemRenLuyen = rs.getInt("maDiemRenLuyen");
			float diemRenLuyen = rs.getFloat("diemRenLuyen");
			int hocKi = rs.getInt("hocKi");
			int maSinhVien = rs.getInt("maSinhVien");
			listDiemRenLuyen.add(new DiemRenLuyen(maDiemRenLuyen, diemRenLuyen, hocKi, maSinhVien));
		}
		connect.cn.close();
		return listDiemRenLuyen;
	}

	public void deleteDiemRenLuyenbyMaSinhVien(int maSinhVien) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Delete from diemrenluyen where maSinhVien = ? ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, maSinhVien);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void deleteDiemRenLuyenbyMaDiemRenLuyen(int maDiemRenLuyen) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Delete from diemrenluyen where maDiemRenLuyen = ? ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, maDiemRenLuyen);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public List<DiemRenLuyen> getAllDiemRenLuyenByKhoa(String maKhoa) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Select * from diemrenluyen D inner join sinhvien SV on D.maSinhVien = SV.maSinhVien "
				+ " inner join Lop L on SV.maLop = L.maLop " + " inner join Khoa K on K.maKhoa = L.maKhoa"
				+ " where K.maKhoa = ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, maKhoa);
		List<DiemRenLuyen> listDiemRenLuyen = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maDiemRenLuyen = rs.getInt("maDiemRenLuyen");
			float diemRenLuyen = rs.getFloat("diemRenLuyen");
			int hocKi = rs.getInt("hocKi");
			int maSinhVien = rs.getInt("maSinhVien");
			listDiemRenLuyen.add(new DiemRenLuyen(maDiemRenLuyen, diemRenLuyen, hocKi, maSinhVien));
		}
		connect.cn.close();
		return listDiemRenLuyen;

	}

	public List<DiemRenLuyen> getAllDiemRenLuyenByLop(String maLop) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Select * from diemrenluyen D inner join sinhvien SV on D.maSinhVien = SV.maSinhVien "
				+ " inner join Lop L on SV.maLop = L.maLop where L.maLop = ?  ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, maLop);
		List<DiemRenLuyen> listDiemRenLuyen = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maDiemRenLuyen = rs.getInt("maDiemRenLuyen");
			float diemRenLuyen = rs.getFloat("diemRenLuyen");
			int hocKi = rs.getInt("hocKi");
			int maSinhVien = rs.getInt("maSinhVien");
			listDiemRenLuyen.add(new DiemRenLuyen(maDiemRenLuyen, diemRenLuyen, hocKi, maSinhVien));
		}
		connect.cn.close();
		return listDiemRenLuyen;

	}

}
