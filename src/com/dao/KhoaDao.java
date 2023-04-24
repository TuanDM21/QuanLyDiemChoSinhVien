package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Khoa;

public class KhoaDao {
	public List<Khoa> getAllKhoa() throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Select * from khoa";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		List<Khoa> listKhoa = new ArrayList<>();
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String maKhoa = rs.getString("maKhoa");
			String tenKhoa = rs.getString("tenKhoa");
			listKhoa.add(new Khoa(maKhoa, tenKhoa));
		}
		connect.cn.close();
		return listKhoa;
	}
}
